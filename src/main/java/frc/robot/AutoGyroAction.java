/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//for navx gyro
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class AutoGyroAction {

    AHRS ahrs;
    double rotateToAngle;
    double currentAngle;
    Drivetrain useTalon;

    public AutoGyroAction(AHRS ahrs, Drivetrain drivetrain) {

        this.ahrs = ahrs;
        this.useTalon = drivetrain;

        currentAngle = ahrs.getAngle();

    }

    public void NavxGyro() {

        // example

        if (currentAngle > (rotateToAngle - .5)) {

            // move robot a certain way code

        }

        else if (currentAngle < (rotateToAngle - .5)) {

            // moves robot other way if it over shoots

        }

        else {

            // robot not move

        }

    }

    public void rotateToAngle90FromStart() {

        if (currentAngle < 89.5) {

            useTalon.T_1.set(0.5);
            useTalon.T_2.set(-0.5);

        } else if (currentAngle > 90.5) {
            useTalon.T_1.set(-0.5);
            useTalon.T_2.set(0.5);

        } else {
            useTalon.T_1.set(0.0);
            useTalon.T_2.set(0.0);

        }

    }

    public void rotateToAngleNegative90FromStart() {

        if (currentAngle < -89.5) {

            useTalon.T_1.set(-0.5);
            useTalon.T_2.set(0.5);

        } else if (currentAngle > -90.5) {
            useTalon.T_1.set(0.5);
            useTalon.T_2.set(-0.5);

        } else {
            useTalon.T_1.set(0.0);
            useTalon.T_2.set(0.0);

        }

    }

    public void rotateToAngle180FromStart() {

        if (currentAngle < 179.5) {

            useTalon.T_1.set(0.5);
            useTalon.T_2.set(-0.5);

        } else if (currentAngle > 180.5) {
            useTalon.T_1.set(-0.5);
            useTalon.T_2.set(0.5);

        } else {
            useTalon.T_1.set(0.0);
            useTalon.T_2.set(0.0);

        }
    }

    public void rotateToAngleNegative180FromStart() {

        if (currentAngle < -179.5) {

            useTalon.T_1.set(-0.5);
            useTalon.T_2.set(0.5);

        } else if (currentAngle > -180.5) {
            useTalon.T_1.set(0.5);
            useTalon.T_2.set(-0.5);

        } else {
            useTalon.T_1.set(0.0);
            useTalon.T_2.set(0.0);

        }
    }

    public void rotateToAngle270FromStart() {

        if (currentAngle < 269.5) {

            useTalon.T_1.set(0.5);
            useTalon.T_2.set(-0.5);

        } else if (currentAngle > 270.5) {
            useTalon.T_1.set(-0.5);
            useTalon.T_2.set(0.5);

        } else {
            useTalon.T_1.set(0.0);
            useTalon.T_2.set(0.0);

        }
    }

    public void rotateToAngleNegative270FromStart() {

        if (currentAngle < -269.5) {

            useTalon.T_1.set(-0.5);
            useTalon.T_2.set(0.5);

        } else if (currentAngle > -270.5) {
            useTalon.T_1.set(0.5);
            useTalon.T_2.set(-0.5);

        } else {
            useTalon.T_1.set(0.0);
            useTalon.T_2.set(0.0);

        }
    }

    public void rotateToAngleTest() {

        if (currentAngle < -269.5) {

            useTalon.T_1.set(-0.001);
            useTalon.T_2.set(0.001);

        } else if (currentAngle > -270.5) {
            useTalon.T_1.set(0.001);
            useTalon.T_2.set(-0.001);

        } else {
            useTalon.T_1.set(0.0);
            useTalon.T_2.set(0.0);

        }
    }

    public void SmartDashBoard() {

        SmartDashboard.putNumber("Current Angle", currentAngle);
        System.out.print(ahrs.getAngle());

    }
}
