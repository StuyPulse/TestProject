package com.stuypulse.robot.subsystems.swervetests;

import com.stuypulse.robot.subsystems.swervetests.module.SwerveModuleTest;


import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveTest extends SubsystemBase{
private final SwerveModuleTest[] modules;

SendableChooser<SwerveModuleTest> moduleChooser = new SendableChooser<SwerveModuleTest>();
public SwerveTest(SwerveModuleTest... modules) {
    
    new SwerveModuleTest("FrontRight", 10, 11, 1);
    new SwerveModuleTest("FrontLeft", 12, 13, 2);
    new SwerveModuleTest("BackLeft", 14, 15, 3);
    new SwerveModuleTest("BackRight", 16, 17, 4);

    this.modules = modules;
 
    for (var module : modules){
        moduleChooser.addOption(module.getID(), module);
    }

    SmartDashboard.putData(moduleChooser);
    }

    public void setDriveVoltage(double voltage){
        moduleChooser.getSelected().setDriveVoltage(voltage);
    }
    public void setTurnVoltage(double voltage){
        moduleChooser.getSelected().setTurnMotor(voltage);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Turn Encoder Raw Vel", moduleChooser.getSelected().getTurnRawVelocity());
        SmartDashboard.putNumber("Drive Encoder RPM", moduleChooser.getSelected().getDriveEncoderRPM());
    }
}