package com.stuypulse.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.stuypulse.robot.constants.Ports;

public class ConveyerTest {
    private final CANSparkMax gandalfMotor;
    private final CANSparkMax shooterFeederMotor;
    private final RelativeEncoder gandalfEncoder;
    private final RelativeEncoder shooterFeederEncoder;

    public ConveyerTest(){
        gandalfMotor = new CANSparkMax(Ports.Conveyor.GANDALF, MotorType.kBrushless);
        shooterFeederMotor = new CANSparkMax(Ports.Conveyor.FEEDER, MotorType.kBrushless);

        gandalfEncoder = gandalfMotor.getEncoder();
        shooterFeederEncoder = shooterFeederMotor.getEncoder();
    }

    public void setGandalfVoltage(double voltage){
        gandalfMotor.set(voltage);
    }

    public void setShooterFeederVoltage(double voltage){
        shooterFeederMotor.set(voltage);
    }

    public void stop(){
        gandalfMotor.set(0);
        shooterFeederMotor.set(0);
    }

}