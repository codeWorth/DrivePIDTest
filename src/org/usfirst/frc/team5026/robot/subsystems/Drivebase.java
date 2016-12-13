package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.RobotMap;
import org.usfirst.frc.team5026.robot.commands.DrivebasePID;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivebase extends Subsystem {
	
	public void setLeftPower(double power) {
		RobotMap.leftMotor.set(power);
	}
	
	public void setRightPower(double power) {
		RobotMap.rightMotor.set(power);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new DrivebasePID());
    }
}

