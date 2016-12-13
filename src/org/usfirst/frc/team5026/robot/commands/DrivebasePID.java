package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.lib.Buffer;
import org.usfirst.frc.team5026.lib.Constants;
import org.usfirst.frc.team5026.robot.OI;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivebasePID extends Command {
	
	private final double joyXToTurn = 2;
	private final double joyYToSpeed = 3;
	
	private double prevSpeedError = 0;
	private Buffer moveRateSum;
	
	private double prevGyroError = 0;
	private Buffer gyroRateSum;
	
    	public DrivebasePID() {
    		requires(Robot.drivebase);
    	
    		moveRateSum = new Buffer(50);
    		gyroRateSum = new Buffer(25);
    	}

	private double wantedSpeed() {
		return OI.stick.getY() * joyYToSpeed;
	}


	private double wantedTurn() {
		return OI.stick.getX() * joyXToTurn;
	}
	
	private double encoderError() {
		double averageSpeed = (RobotMap.leftEncoder.getRate() + RobotMap.rightEncoder.getRate()) / 2;
		return (averageSpeed - wantedSpeed());
	}

	private double gyroError() {
		return (RobotMap.gyro.getRate() - wantedTurn());
	}

    	// Called just before this Command runs the first time
   	protected void initialize() {
    		RobotMap.gyro.calibrate();
    		RobotMap.gyro.reset();
    	
    		RobotMap.leftEncoder.reset();
    		RobotMap.rightEncoder.reset();
    	}

    	// Called repeatedly when this Command is scheduled to run
    	protected void execute() {
    		double speedError = encoderError();
		double speedSum = moveRateSum.push(speedError);
    		double speedDelta = speedError - prevSpeedError;
		
    		double wantedSpeed = speedError * Constants.DRIVE_SPEED_P + speedSum * Constants.DRIVE_SPEED_I + speedDelta * Constants.DRIVE_SPEED_D;

		prevSpeedError = speedError;

		double turnError = gyroError();
		double turnSum = turnRateSum.push(turnError);
		double turnDelta = turnError - prevTurnError;

		double wantedTurn = turnError * Constants.DRIVE_TURN_P + turnSum * Constants.DRIVE_TURN_I + turnDelta * Constants.DRIVE_TURN_D; 

		prevTurnError = turnError;
	
    	}

	// Make this return true when this Command no longer needs to run execute()h
	protected boolean isFinished() {
        	return false;
    	}

    	// Called once after isFinished returns true
    	protected void end() {
    	}

    	// Called when another command which requires one or more of the same
    	// subsystems is scheduled to run
    	protected void interrupted() {
    	}
}



