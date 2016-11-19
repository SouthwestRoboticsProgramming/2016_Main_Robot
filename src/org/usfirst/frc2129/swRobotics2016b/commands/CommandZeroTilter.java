package org.usfirst.frc2129.swRobotics2016b.commands;

import org.usfirst.frc2129.swRobotics2016b.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CommandZeroTilter extends Command {
	
	Timer timer;

    public CommandZeroTilter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.subsystemTilter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer=new Timer();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.subsystemTilter.TilterUp();
    	SmartDashboard.putNumber("tiemerstatus", timer.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get()>1;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.subsystemTilter.encoder.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
