package com.stuypulse.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.stuypulse.robot.constants.Ports;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConveyerTest extends SubsystemBase{
    private final CANSparkMax gandalfMotor;
    private final CANSparkMax shooterFeederMotor;
    private final RelativeEncoder gandalfEncoder;
    private final RelativeEncoder shooterFeederEncoder;

    private final DigitalInput IRSensor;

    public ConveyerTest(){
        gandalfMotor = new CANSparkMax(Ports.Conveyor.GANDALF, MotorType.kBrushless);
        shooterFeederMotor = new CANSparkMax(Ports.Conveyor.FEEDER, MotorType.kBrushless);

        gandalfEncoder = gandalfMotor.getEncoder();
        shooterFeederEncoder = shooterFeederMotor.getEncoder();

        IRSensor = new DigitalInput(Ports.Conveyor.IR_SENSOR);
    }

    public void setGandalfVoltage(double voltage){
        gandalfMotor.set(voltage);
    }

    public void setShooterFeederVoltage(double voltage){
        shooterFeederMotor.set(voltage);
    }

    public double getGandalfEncoder() {
        return gandalfEncoder.getVelocity();
    }

    public double getShooterFeederEncoder() {
        return shooterFeederEncoder.getVelocity();
    }

    public void stop(){
        gandalfMotor.set(0);
        shooterFeederMotor.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Conveyor/Gandalf Motor Current", gandalfMotor.getOutputCurrent());
        SmartDashboard.putNumber("Conveyor/Shooter Feeder Motor Current", shooterFeederMotor.getOutputCurrent());
        SmartDashboard.putNumber("Conveyor/Gandalf Motor Speed", gandalfMotor.get());
        SmartDashboard.putNumber("Conveyor/Shooter Feeder Motor Spped", shooterFeederMotor.get());
        SmartDashboard.putBoolean("Conveyor/Conveyor Has Note", !IRSensor.get());
    }
}