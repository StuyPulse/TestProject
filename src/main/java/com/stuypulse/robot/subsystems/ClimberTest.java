package com.stuypulse.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.stuypulse.robot.constants.Ports;

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

    public double getLeftEncoder(){
        return leftEncoder.getVelocity();
    }

    public double getRightEncoder(){
        return rightEncoder.getVelocity();   
    }
    
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Climber/Left Voltage", leftMotor.getAppliedOutput() * leftMotor.getBusVoltage());
        SmartDashboard.putNumber("Climber/Right Voltage", rightMotor.getAppliedOutput() * rightMotor.getBusVoltage());
        SmartDashboard.putNumber("Climber/Height", getRightEncoder());
        SmartDashboard.putNumber("Climber/Velocity", getLeftEncoder());
    }
}


