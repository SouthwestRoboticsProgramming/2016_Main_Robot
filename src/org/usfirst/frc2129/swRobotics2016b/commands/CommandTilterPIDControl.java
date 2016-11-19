package org.usfirst.frc2129.swRobotics2016b.commands;

import org.usfirst.frc2129.swRobotics2016b.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CommandTilterPIDControl extends Command {

    public CommandTilterPIDControl() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.subsystemTilter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!Robot.subsystemTilter.pid_controller.isEnabled())
    		Robot.subsystemTilter.pidStart();

    	double value = Preferences.getInstance().getDouble("pid_target", 0f);
    	if (value!=Robot.subsystemTilter.pid_controller.getSetpoint())
    		Robot.subsystemTilter.pidSet(value);
    	SmartDashboard.putNumber("PIDTarget", value);
    	float newp = Preferences.getInstance().getFloat("p", 0.1f);
    	float newi = Preferences.getInstance().getFloat("i", 0.2f);
    	float newd = Preferences.getInstance().getFloat("d", 0.02f);
    	if (newp!=Robot.subsystemTilter.pid_controller.getP() ||
    			newi!=Robot.subsystemTilter.pid_controller.getI() ||
    			newd!=Robot.subsystemTilter.pid_controller.getD()){
    		Robot.subsystemTilter.pid_controller.setPID(newp, newi, newd);
    	}
    	SmartDashboard.putNumber("pid_avgerr", Robot.subsystemTilter.pid_controller.getAvgError());
    	SmartDashboard.putNumber("pid_delta", Robot.subsystemTilter.pid_controller.getDeltaSetpoint());
    	SmartDashboard.putNumber("pid_err", Robot.subsystemTilter.pid_controller.getError());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.subsystemTilter.pid_controller.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.subsystemTilter.pidStop();
    	Robot.subsystemTilter.TilterStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.subsystemTilter.pidStop();
    }
}
