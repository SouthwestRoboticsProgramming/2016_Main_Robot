package org.usfirst.frc2129.swRobotics2016b.commands;

import org.usfirst.frc2129.swRobotics2016b.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class CommandStreamCamera extends Command {
	public CommandStreamCamera() {
		requires(Robot.cameraSubsystem);
	}

	protected void execute() {
//		Robot.cameraSubsystem.streamer.update();
		String s = Preferences.getInstance().getString("camera", "0");
		if(s=="0"){
			Robot.cameraSubsystem.setCam1();
		}else{
			Robot.cameraSubsystem.setCam2();
		}
		
//		SmartDashboard.putBoolean("cam0_init", Robot.cameraSubsystem.cam1.isInitilized());
//		SmartDashboard.putBoolean("cam1_init", Robot.cameraSubsystem.cam2.isInitilized());
//		SmartDashboard.putBoolean("cam0_ready", Robot.cameraSubsystem.cam1.isReady());
//		SmartDashboard.putBoolean("cam1_ready", Robot.cameraSubsystem.cam2.isReady());
//		SmartDashboard.putNumber("cam0_rate", Robot.cameraSubsystem.cam1.getRealFramerate());
//		SmartDashboard.putNumber("cam1_rate", Robot.cameraSubsystem.cam2.getRealFramerate());
	}
		
	protected boolean isFinished() {return false;}
	protected void end() {}
	protected void initialize() {}
	protected void interrupted() {}

}
