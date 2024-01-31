package com.stuypulse.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.stuypulse.robot.constants.Ports;

public class IntakeTest {
    private final CANSparkMax motor;

    public IntakeTest() {
        motor = new CANSparkMax(Ports.Intake.MOTOR, MotorType.kBrushless);
    }
    public void setIntakeVoltage(double voltage) {
        motor.set(voltage);
    }

    public void stop() {
        motor.set(0);
    }

}