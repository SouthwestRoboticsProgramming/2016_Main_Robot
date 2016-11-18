package org.usfirst.frc2129.swRobotics2016b;

import org.usfirst.frc2129.swRobotics2016b.subsystems.PowerDistribution;
import org.usfirst.frc2129.swRobotics2016b.subsystems.SubsystemUltrasonic;
import org.usfirst.frc2129.swRobotics2016b.subsystems.SubsystemDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Telemetry {

	static NetworkTable loggingNetworkTable = NetworkTable.getTable("2129/log");
	static String NETWORK_TABLE_LOG_ENTRY_KEY = "logEntry";
	
	//Values for current related stuff
	static double totalCurrent = 0.0;
	static double CurrentLeft = 0.0;
	static double MaxCurrentLeft = 0.0;
	static double CurrentRight = 0.0;
	static double MaxCurrentRight = 0.0;
	
	static public void reportDrivePower( SubsystemDrive subsystemDrive
			, PowerDistribution powerDistribution ) 
	{
		totalCurrent = 0.0;
        
        //Poll Current
        CurrentLeft = powerDistribution.getCurrent(0);
        totalCurrent += CurrentLeft;
        CurrentRight = powerDistribution.getCurrent(1);
        totalCurrent += CurrentRight;
        
        //Handle Current Min/Max for Right Side
        if (CurrentRight > MaxCurrentRight)
        	MaxCurrentRight = CurrentRight;
        
        //Handle Current Min/Max for Left Side
        if (CurrentLeft > MaxCurrentLeft)
        	MaxCurrentLeft = CurrentLeft;
         
        //Push Data to SmartDashboard
        SmartDashboard.putNumber("Right Current", CurrentRight);
        SmartDashboard.putNumber("Right Max Current", MaxCurrentRight);
        SmartDashboard.putNumber("Left Current", CurrentLeft);
        SmartDashboard.putNumber("Left Max Current", MaxCurrentLeft);
        
        SmartDashboard.putNumber("Elevator Current", powerDistribution.getCurrent(13));
        totalCurrent += powerDistribution.getCurrent(13);
        SmartDashboard.putNumber("IntakeRoller Current", powerDistribution.getCurrent(14));
        totalCurrent += powerDistribution.getCurrent(14);
        SmartDashboard.putNumber("SpinnerLeft Current", powerDistribution.getCurrent(15));
        totalCurrent += powerDistribution.getCurrent(15);
        SmartDashboard.putNumber("SpinnerRight", powerDistribution.getCurrent(2));
        totalCurrent += powerDistribution.getCurrent(2);
        
        // Capture drive encoder rates 
        double RateLeft = subsystemDrive.GetLeftRate();
        double RateRight = subsystemDrive.GetRightRate();
        
        SmartDashboard.putNumber("Left Rate", RateLeft);
        SmartDashboard.putNumber("Right Rate", RateRight);
        Log( String.format("%f\t%f\t%f\t%f%n", CurrentLeft, CurrentRight, RateLeft, RateRight));
	}

	public static void initDriveCurrent() {
    	//Handle Reseting current meter
		MaxCurrentRight = 0.0;
    	MaxCurrentLeft = 0.0;
    	
    	Log( "Left Current\tRight Current\tLeft Rate\tRight Rate");
	}
	
	public static void LogEncoder(String prefix, Encoder encoder){
		SmartDashboard.putNumber(prefix+".getDistance():", encoder.getDistance());
		SmartDashboard.putNumber(prefix+".get():", encoder.get());
		SmartDashboard.putNumber(prefix+".getRate():", encoder.getRate());
		SmartDashboard.putNumber(prefix+".pidGet():", encoder.pidGet());
		SmartDashboard.putNumber(prefix+".getRaw():", encoder.getRaw());
	}
	
	public static void Log( String logMsg )
	{
		loggingNetworkTable.putString( NETWORK_TABLE_LOG_ENTRY_KEY
				, String.format( "%d: %s", System.currentTimeMillis(), logMsg ) );
	}

}
