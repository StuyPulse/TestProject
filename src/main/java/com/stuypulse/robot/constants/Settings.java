/************************ PROJECT PHIL ************************/
/* Copyright (c) 2024 StuyPulse Robotics. All rights reserved.*/
/* This work is licensed under the terms of the MIT license.  */
/**************************************************************/

package com.stuypulse.robot.constants;

import com.stuypulse.stuylib.network.SmartBoolean;
import com.stuypulse.stuylib.network.SmartNumber;
import edu.wpi.first.math.util.Units;

/*-
 * File containing tunable settings for every subsystem on the robot.
 *
 * We use StuyLib's SmartNumber / SmartBoolean in order to have tunable
 * values that we can edit on Shuffleboard.
 */
public interface Settings {

    public interface AmperTest {

        double AMP_ROLLER_DIAMETER = Units.inchesToMeters(1.25);
        public interface Lift{
            public interface Encoder {
            double GEARING = 9;
            double DRUM_RADIUS = Units.inchesToMeters(1);
            double DRUM_CIRCUMFERENCE = DRUM_RADIUS * Math.PI * 2;

            double POSITION_CONVERSION = GEARING * DRUM_CIRCUMFERENCE;
            double VELOCITY_CONVERSION = POSITION_CONVERSION / 60.0;
            }
        }
        public interface Score {
            SmartNumber SCORE_SPEED = new SmartNumber("Amper/Score/Score Speed", 1.0);
            SmartNumber INTAKE_SPEED = new SmartNumber("Amper/Score/Intake Speed", 1.0);

            double SCORE_MOTOR_CONVERSION = AMP_ROLLER_DIAMETER * Math.PI;
        }
        
    }

    public interface ClimberTest {

        public interface Encoder {
            double GEAR_RATIO = 12.0;

            double POSITION_CONVERSION = 1.0;
            double VELOCITY_CONVERSION = POSITION_CONVERSION / 60.0;
        }
    }



}
