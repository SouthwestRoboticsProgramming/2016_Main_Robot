// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2129.swRobotics2016b.subsystems;

import org.usfirst.frc2129.swRobotics2016b.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class IntakeRoller extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon intakeMotor = RobotMap.intakeRollerIntakeMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        setDefaultCommand(new org.usfirst.frc2129.swRobotics2016b.commands.intakeRoller_spinStop());
    }
    
    //Set motor to pull in
    public void SetIntakeIn() {
    	intakeMotor.set(0.75);
    }
    
    //Set motor to output
    public void SetIntakeOut() {
    	intakeMotor.set(-0.5);
    }
    
    //Set motor to stop
    public void SetIntakeStop() {
    	intakeMotor.set(0.0);
    }
}

