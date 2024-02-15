package com.stuypulse.robot.subsystems.swervetests.module;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;


public class SwerveModuleTest {
    private final CANSparkMax turnMotor;
    private final CANSparkFlex driveMotor;
    private final String id;

    private final RelativeEncoder driveEncoder;
    private final CANcoder turnEncoder;

    public SwerveModuleTest(String id, int driveID, int turnID, int encoderID) {
        turnMotor = new CANSparkMax(turnID, MotorType.kBrushless);
        driveMotor = new CANSparkFlex(driveID, MotorType.kBrushless);

        driveEncoder = driveMotor.getEncoder();
        turnEncoder = new CANcoder(encoderID);

        this.id = id;
    } 

    public void setTurnMotor(double voltage){
        turnMotor.set(voltage);
    }

    public void setDriveVoltage(double voltage) {
        driveMotor.set(voltage);
    }

    public double getDriveEncoderRPM() {
        return driveEncoder.getVelocity();
    }

    public double getTurnRawVelocity() {
        return turnEncoder.getVelocity().getValueAsDouble();
    }

    public String getID(){
        return id;
    }
}