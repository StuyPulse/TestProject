package com.stuypulse.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.stuypulse.robot.constants.Motors;
import com.stuypulse.robot.constants.Ports;
import com.stuypulse.robot.constants.Settings;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberTest extends SubsystemBase{
    private final CANSparkMax leftMotor;
    private final CANSparkMax rightMotor;
    private final RelativeEncoder rightEncoder;
    private final RelativeEncoder leftEncoder;
    
    public ClimberTest(){
        leftMotor = new CANSparkMax(Ports.Climber.LEFT_MOTOR, MotorType.kBrushless);
        rightMotor = new CANSparkMax(Ports.Climber.RIGHT_MOTOR, MotorType.kBrushless);

        rightEncoder = rightMotor.getEncoder();
        leftEncoder = leftMotor.getEncoder();

        rightEncoder.setPositionConversionFactor(Settings.ClimberTest.Encoder.POSITION_CONVERSION);
        leftEncoder.setPositionConversionFactor(Settings.ClimberTest.Encoder.POSITION_CONVERSION);

        rightEncoder.setVelocityConversionFactor(Settings.ClimberTest.Encoder.VELOCITY_CONVERSION);
        leftEncoder.setVelocityConversionFactor(Settings.ClimberTest.Encoder.VELOCITY_CONVERSION);

        // Motors.Climber.LEFT_MOTOR.configure(leftMotor);
        // Motors.Climber.RIGHT_MOTOR.configure(rightMotor);

    }
    public void setLeftVoltage(double voltage){
        leftMotor.set(voltage);
    }
    public void setRightVoltage(double voltage){
        rightMotor.set(voltage);    
    }

    public void stop() {
        leftMotor.set(0);
        rightMotor.set(0);
    }

    public double getLeftVelocity() {
        return leftEncoder.getVelocity();
    }
    public double getLeftPosition() {
        return leftEncoder.getPosition();
    }

    public double getRightVelocity() {
        return rightEncoder.getVelocity();   
    }

    public double getRightPosition() {
        return rightEncoder.getPosition();
    }
    
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Climber/Left Voltage", leftMotor.getAppliedOutput() * leftMotor.getBusVoltage());
        SmartDashboard.putNumber("Climber/Right Voltage", rightMotor.getAppliedOutput() * rightMotor.getBusVoltage());
        SmartDashboard.putNumber("Climber/Right Height", getRightPosition());
        SmartDashboard.putNumber("Climber/Right Velocity", getRightVelocity());
        SmartDashboard.putNumber("Climber/Left Position", getLeftPosition());
        SmartDashboard.putNumber("Climber/Left Velocity", getLeftVelocity());
    }
}


