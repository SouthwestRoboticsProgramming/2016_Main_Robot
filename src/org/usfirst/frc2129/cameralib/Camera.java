package org.usfirst.frc2129.cameralib;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.VisionException;

public class Camera {
	public static int MAX_TRIES = 3;
	private int session;
	private String port;
	private boolean initilized; //Has the camera been "Opened"
	private boolean ready; //Is the camera "Configured"
	
	private Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	
	public float requested_framerate;
	private float real_sample_rate;
	private long last_grab;
	
	public Camera(String port, int rate){
		this.port=port;
		this.initilized=false;
		this.ready=false;
		this.requested_framerate=rate;
		openCamera();
	}
	
	public Camera(String port){
		this(port, 30);
	}
	
	private void tryOpenCamera(){
		try{
			session = NIVision.IMAQdxOpenCamera(port, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			initilized = true;
		}catch(VisionException err){
			initilized = false;
		}
	}
	
	public void openCamera(){
		assert !initilized;
		int tries = 0;
		while((tries<MAX_TRIES) && (!initilized)){
			tryOpenCamera();
			tries++;
		}
	}
	
	private void tryReadyCamera(){
		try{
			NIVision.IMAQdxConfigureGrab(session);
	        NIVision.IMAQdxStartAcquisition(session);
	        ready = true;
		}catch(VisionException err){
			ready = false;
		}
	}

	public void readyCamera(){
		if(!ready){
			int tries = 0;
			while((tries<MAX_TRIES) && (!ready)){
				tryReadyCamera();
				tries++;
			}
		}
	}
	
	public void unreadyCamera(){
		if(ready){
			try{
				NIVision.IMAQdxStopAcquisition(session);
				NIVision.IMAQdxUnconfigureAcquisition(session);
			}catch(VisionException err){
				//hope it worked
			}
			ready = false;
		}
	}
	
	public void updateFrame(){
		try{
			NIVision.IMAQdxGrab(session, frame, 1);
			long grab_time = System.currentTimeMillis();
			long delta = last_grab - grab_time;
			last_grab = grab_time;
			real_sample_rate = 1f/(delta/1000);
		}catch(VisionException err){
			//hope!
		}
	}
	
	public long getGrabIntervalMS(){
		return (long)(1000f/requested_framerate);
	}
	
	public boolean update(){
		if(System.currentTimeMillis()-last_grab >= getGrabIntervalMS()){
			updateFrame();
			return true;
		}
		return false;
	}

	public Image getFrame(){
		return frame;
	}
	
	public boolean isInitilized() {
		return initilized;
	}
	
	public boolean isReady() {
		return ready;
	}

	public float getRealFramerate(){
		return real_sample_rate;
	}
}
