package org.usfirst.frc2129.swRobotics2016b.subsystems;

import org.usfirst.frc2129.swRobotics2016b.commands.CommandStreamCamera;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class CameraSubsystem extends Subsystem {
	public USBCamera cam1;
	public USBCamera cam2;

	@Override
	protected void initDefaultCommand() {
		cam1 = new USBCamera("cam0");
		cam2 = new USBCamera("cam1");
		
		setDefaultCommand(new CommandStreamCamera());
	}
	
	public void setCam1(){
		CameraServer.getInstance().startAutomaticCapture(cam1);
	}
	
	public void setCam2(){
		CameraServer.getInstance().startAutomaticCapture(cam2);
	}
}
