package com.stuypulse.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.stuypulse.robot.constants.Ports;
import com.stuypulse.robot.constants.Settings;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class AmperTest extends SubsystemBase {
    private final CANSparkMax scoreMotor;
    private final CANSparkMax liftMotor;
    private final RelativeEncoder liftEncoder;
    private final RelativeEncoder scoreEncoder;

    

    public AmperTest(){
        scoreMotor = new CANSparkMax(Ports.Amper.SCORE, MotorType.kBrushless);
        liftMotor = new CANSparkMax(Ports.Amper.LIFT, MotorType.kBrushless);
        liftEncoder = liftMotor.getEncoder();
        scoreEncoder = scoreMotor.getEncoder();

        scoreEncoder.setPositionConversionFactor(Settings.AmperTest.Score.SCORE_MOTOR_CONVERSION);

        liftEncoder.setPositionConversionFactor(Settings.AmperTest.Lift.Encoder.POSITION_CONVERSION);
        liftEncoder.setVelocityConversionFactor(Settings.AmperTest.Lift.Encoder.VELOCITY_CONVERSION);
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

    public double getScorePosition() {
        return scoreEncoder.getPosition();
    }
    public double getLiftPosition() {
        return liftEncoder.getPosition();
    }
    public double getLiftVelocity() {
        return liftEncoder.getVelocity();
    }
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Amper/Intake Speed", scoreMotor.get());
        SmartDashboard.putNumber("Amper/Lift Speed", liftMotor.get());
        SmartDashboard.putNumber("Amper/Intake Current", scoreMotor.getOutputCurrent());
        SmartDashboard.putNumber("Amper/Lift Current", liftMotor.getOutputCurrent());
        SmartDashboard.putNumber("Amper/Lift Position", liftEncoder.getPosition());
        SmartDashboard.putNumber("Amper/Score Position", scoreEncoder.getPosition());
    }
}
