/************************ PROJECT PHIL ************************/
/* Copyright (c) 2024 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot;

import java.util.function.DoubleConsumer;

import com.stuypulse.robot.commands.auton.DoNothingAuton;
import com.stuypulse.robot.constants.Ports;
import com.stuypulse.robot.subsystems.AmperTest;
import com.stuypulse.robot.subsystems.ClimberTest;
import com.stuypulse.robot.subsystems.ConveyerTest;
import com.stuypulse.robot.subsystems.IntakeTest;
import com.stuypulse.robot.subsystems.ShooterTest;
import com.stuypulse.robot.subsystems.swervetests.SwerveTest;
import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.input.gamepads.AutoGamepad;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class RobotContainer {

    // Gamepads
    public final Gamepad driver = new AutoGamepad(Ports.Gamepad.DRIVER);
    public final Gamepad operator = new AutoGamepad(Ports.Gamepad.OPERATOR);
    
    // Subsystem
    private final ShooterTest shooter = new ShooterTest();
    private final AmperTest amper = new AmperTest();
    private final SwerveTest swerve = new SwerveTest();
    private final ClimberTest climber = new ClimberTest();
    private final ConveyerTest conveyer = new ConveyerTest();
    private final IntakeTest intake = new IntakeTest();
    
    
    // Autons
    private static SendableChooser<Command> autonChooser = new SendableChooser<>();

    // Robot container

    public RobotContainer() {
        configureDefaultCommands();
        configureButtonBindings();
        configureAutons();
    }

    /****************/
    /*** DEFAULTS ***/
    /****************/

    private void configureDefaultCommands() {}

    /***************/
    /*** BUTTONS ***/
    /***************/

    private Command runMotorCommand(String name, DoubleConsumer set, Subsystem subsystem) {
        SmartDashboard.putNumber(name, 6.0);

        return new FunctionalCommand(
            () -> set.accept(SmartDashboard.getNumber(name, 0.0)),
            () -> {},
            (Boolean interrupted) -> set.accept(0.0),
            () -> false,
            subsystem);
    }

    private void configureButtonBindings() {
        driver.getTopButton()
            .whileTrue(runMotorCommand("Shooter left voltage", shooter::setLeftVoltage, shooter));
    }


    
    
    /**************/
    /*** AUTONS ***/    
    /**************/

    public void configureAutons() {
        autonChooser.setDefaultOption("Do Nothing", new DoNothingAuton());

        SmartDashboard.putData("Autonomous", autonChooser);
    }

    public Command getAutonomousCommand() {
        return autonChooser.getSelected();
    }
}
