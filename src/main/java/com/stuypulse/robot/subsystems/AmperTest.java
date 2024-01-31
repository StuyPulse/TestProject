package com.stuypulse.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.stuypulse.robot.constants.Ports;


public class AmperTest {
    private final CANSparkMax scoreMotor;
    private final CANSparkMax liftMotor;
    private final RelativeEncoder liftEncoder;

    public AmperTest(){
        scoreMotor = new CANSparkMax(Ports.Amper.SCORE, MotorType.kBrushless);
        liftMotor = new CANSparkMax(Ports.Amper.LIFT, MotorType.kBrushless);
        liftEncoder = liftMotor.getEncoder();
    }

    public void setAmperVoltage(double voltage){
        scoreMotor.set(voltage);
    }

    public void setLiftVoltage(double voltage){
        liftMotor.set(voltage);
    }

    public void stop(){
        scoreMotor.set(0);
        liftMotor.set(0);
    }
}
