package com.stuypulse.robot.subsystems;

import com.stuypulse.robot.constants.Ports;
import com.stuypulse.stuylib.network.SmartNumber;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class ShooterTest {
    private final CANSparkMax leftMotor;
    private final CANSparkMax rightMotor;

    private final RelativeEncoder leftEncoder;
    private final RelativeEncoder rightEncoder;
    public ShooterTest() {
        leftMotor = new CANSparkMax(Ports.Shooter.LEFT_MOTOR, MotorType.kBrushless);
        rightMotor = new CANSparkMax(Ports.Shooter.RIGHT_MOTOR, MotorType.kBrushless);
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
}