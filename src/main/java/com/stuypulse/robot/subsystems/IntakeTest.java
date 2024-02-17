package com.stuypulse.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.stuypulse.robot.constants.Ports;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeTest extends SubsystemBase{
    private final CANSparkMax motor;
    private final DigitalInput IRSensor;

    public IntakeTest() {
        motor = new CANSparkMax(Ports.Intake.MOTOR, MotorType.kBrushless);
        IRSensor = new DigitalInput(Ports.Intake.IR_SENSOR);
    }
    public void setIntakeVoltage(double voltage) {
        motor.set(voltage);
    }

    public void stop() {
        motor.set(0);
    } 

    @Override
    public void periodic(){
        SmartDashboard.putBoolean("Intake/ Intake has Note", !IRSensor.get());
    }
}

