// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2129.swRobotics2016b;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Encoder subsystemDriveEncoderDriveLeft;
    public static Encoder subsystemDriveEncoderDriveRight;
    public static SpeedController subsystemDriveleft1;
    public static SpeedController subsystemDriveleft2;
    public static SpeedController subsystemDriveright1;
    public static SpeedController subsystemDriveright2;
    public static RobotDrive subsystemDrivetankDrive;
    public static SpeedController subsystemSpinnersMotorSpinnerLeft;
    public static SpeedController subsystemSpinnersMotorSpinnerRight;
    public static CANTalon subsystemIntakeRollercTalonRoller;
    public static PowerDistributionPanel powerDistributionpowerDistributionPanel;
    public static Servo subsystemPusherServoPusher;
    public static CANTalon subsystemElevatorcTalonElevator;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        subsystemDriveEncoderDriveLeft = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("SubsystemDrive", "EncoderDriveLeft", subsystemDriveEncoderDriveLeft);
        subsystemDriveEncoderDriveLeft.setDistancePerPulse(1.0);
        subsystemDriveEncoderDriveLeft.setPIDSourceType(PIDSourceType.kRate);
        subsystemDriveEncoderDriveRight = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("SubsystemDrive", "EncoderDriveRight", subsystemDriveEncoderDriveRight);
        subsystemDriveEncoderDriveRight.setDistancePerPulse(1.0);
        subsystemDriveEncoderDriveRight.setPIDSourceType(PIDSourceType.kRate);
        subsystemDriveleft1 = new Talon(0);
        LiveWindow.addActuator("SubsystemDrive", "left1", (Talon) subsystemDriveleft1);
        
        subsystemDriveleft2 = new Talon(1);
        LiveWindow.addActuator("SubsystemDrive", "left2", (Talon) subsystemDriveleft2);
        
        subsystemDriveright1 = new Talon(2);
        LiveWindow.addActuator("SubsystemDrive", "right1", (Talon) subsystemDriveright1);
        
        subsystemDriveright2 = new Talon(3);
        LiveWindow.addActuator("SubsystemDrive", "right2", (Talon) subsystemDriveright2);
        
        subsystemDrivetankDrive = new RobotDrive(subsystemDriveleft1, subsystemDriveleft2,
              subsystemDriveright1, subsystemDriveright2);
        
        subsystemDrivetankDrive.setSafetyEnabled(true);
        subsystemDrivetankDrive.setExpiration(0.1);
        subsystemDrivetankDrive.setSensitivity(0.5);
        subsystemDrivetankDrive.setMaxOutput(1.0);

        subsystemDrivetankDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        subsystemDrivetankDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        subsystemSpinnersMotorSpinnerLeft = new Jaguar(4);
        LiveWindow.addActuator("SubsystemSpinners", "MotorSpinnerLeft", (Jaguar) subsystemSpinnersMotorSpinnerLeft);
        
        subsystemSpinnersMotorSpinnerRight = new Jaguar(5);
        LiveWindow.addActuator("SubsystemSpinners", "MotorSpinnerRight", (Jaguar) subsystemSpinnersMotorSpinnerRight);
        
        subsystemIntakeRollercTalonRoller = new CANTalon(1);
        LiveWindow.addActuator("SubsystemIntakeRoller", "cTalonRoller", subsystemIntakeRollercTalonRoller);
        
        powerDistributionpowerDistributionPanel = new PowerDistributionPanel(0);
        LiveWindow.addSensor("PowerDistribution", "powerDistributionPanel", powerDistributionpowerDistributionPanel);
        
        subsystemPusherServoPusher = new Servo(6);
        LiveWindow.addActuator("SubsystemPusher", "ServoPusher", subsystemPusherServoPusher);
        
        subsystemElevatorcTalonElevator = new CANTalon(0);
        LiveWindow.addActuator("SubsystemElevator", "cTalonElevator", subsystemElevatorcTalonElevator);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        ((Jaguar)subsystemSpinnersMotorSpinnerLeft).enableDeadbandElimination(true);
        ((Jaguar)subsystemSpinnersMotorSpinnerRight).enableDeadbandElimination(true);
    }
}
