package org.usfirst.frc2129.cameralib;

import java.util.ArrayList;
import java.util.List;

import com.ni.vision.VisionException;

import edu.wpi.first.wpilibj.CameraServer;

public class CameraStreamer {
	private static CameraStreamer the;
	private static boolean created = false;
	
	public static CameraStreamer get(){
		if(!created){
			the = new CameraStreamer();
			created = true;
		}
		return the;
	}
	
	private CameraServer server;
	private List<Camera> cameras = new ArrayList<Camera>();
	Camera active = null;
	private float requested_rate;
	
	private CameraStreamer(){
		server=CameraServer.getInstance();
	}
	
	public void setQuality(int quality){
		server.setQuality(quality);
		requested_rate=30f;
	}
	
	public void setSize(int size){
		server.setSize(size);
	}
	
	public void setRate(int rate){
		requested_rate=30f;
		if(active!=null){
			active.requested_framerate=rate;
		}
	}
	
	public void addCamera(Camera cam){
		if(!cameras.contains(cam)){
			cameras.add(cam);
		}
	}
	
	private void unreadyCameras(){
		for(Camera cam : cameras){
			cam.unreadyCamera();
		}
	}
	
	public void setCamera(Camera cam){
		if(active!=cam){
			unreadyCameras();
			addCamera(cam);
			active=cam;
			active.requested_framerate=requested_rate;
			active.readyCamera();
			active.updateFrame();
			updateImage();
		}
	}
	
	public void update(){
		if(active!=null){
			if(active.update()){
				updateImage();
			}
		}
	}
	
	private void updateImage(){
		try{
			server.setImage(active.getFrame());
		}catch(VisionException err){
			//Hope and pray
		}
	}
}
