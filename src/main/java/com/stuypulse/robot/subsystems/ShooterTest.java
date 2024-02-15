package com.stuypulse.robot.subsystems;

import com.stuypulse.robot.constants.Ports;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class ShooterTest extends SubsystemBase{
    private final CANSparkFlex leftMotor;
    private final CANSparkFlex rightMotor;

    private final RelativeEncoder leftEncoder;
    private final RelativeEncoder rightEncoder;
    public ShooterTest() {
        leftMotor = new CANSparkFlex(Ports.Shooter.LEFT_MOTOR, MotorType.kBrushless);
        rightMotor = new CANSparkFlex(Ports.Shooter.RIGHT_MOTOR, MotorType.kBrushless);

        leftEncoder = leftMotor.getEncoder();
        rightEncoder = rightMotor.getEncoder();
    }

    public void setRightVoltage(double voltage) {
        rightMotor.set(voltage);
    }

    public void setLeftVoltage(double voltage) {
        leftMotor.set(voltage);
    }

    public void stop() {
        leftMotor.set(0);
        rightMotor.set(0);
    }

    public double getRightShooterRPM(){
        return rightEncoder.getVelocity();
    }
    public double getLeftShooterRPM(){
        return leftEncoder.getVelocity();
    }
    
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Shooter/Right RPM", getRightShooterRPM());
        SmartDashboard.putNumber("Shooter/Left RPM", getLeftShooterRPM());
        SmartDashboard.putNumber("Shooter/Left Voltage", leftMotor.getBusVoltage() * leftMotor.getAppliedOutput());
        SmartDashboard.putNumber("Shooter/Right Voltage", rightMotor.getBusVoltage() * rightMotor.getAppliedOutput());
    }
}