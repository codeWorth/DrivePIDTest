package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.lib.PantherMotorGroup;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    private static int leftMotorPortA = 0;
    private static int leftMotorPortB = 1;
    public static SpeedController leftMotor;
    
    private static int rightMotorPortA = 2;
    private static int rightMotorPortB = 3;
    public static SpeedController rightMotor;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
    
    private static int gyroPort = 1;
    public static Gyro gyro;
    
    private static int leftEncoderA = 2;
    private static int leftEncoderB = 3;
    public static Encoder leftEncoder;
    
    private static int rightEncoderA = 4;
    private static int rightEncoderB = 5;
    public static Encoder rightEncoder;
    
    
    public static void init() {
    	
    	CANTalon leftMotorA = new CANTalon(leftMotorPortA);
    	CANTalon leftMotorB = new CANTalon(leftMotorPortB);
    	leftMotor = new PantherMotorGroup(leftMotorA, leftMotorB);
    	
    	CANTalon rightMotorA = new CANTalon(rightMotorPortA);
    	CANTalon rightMotorB = new CANTalon(rightMotorPortB);
    	rightMotor = new PantherMotorGroup(rightMotorA, rightMotorB);
    	
    	gyro = new AnalogGyro(gyroPort);
    	
    	leftEncoder = new Encoder(leftEncoderA, leftEncoderB);
    	rightEncoder = new Encoder(rightEncoderA, rightEncoderB);
    	
    }
}
