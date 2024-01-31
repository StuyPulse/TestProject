package com.stuypulse.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.stuypulse.robot.constants.Ports;

public class ClimberTest{
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

}


