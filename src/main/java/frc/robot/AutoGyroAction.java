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
    double error;
    double prevError = 0;
    double sumError = 0;
    double output;
    double p;

    public AutoGyroAction(AHRS ahrs, Drivetrain drivetrain) {

        this.ahrs = ahrs;
        this.useTalon = drivetrain;

    }

    public void resetGyro() {
        ahrs.reset();
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

    public void rotateToAngle(double target) {

        currentAngle = ahrs.getAngle();
        error = Math.abs((target - currentAngle)) / 360;
        System.out.println("current angle: " + currentAngle);

        sumError = sumError + error * .02;

        System.out.println("sumError: " + sumError);

        output = .7 * Math.sqrt(error);
        System.out.println("output: " + output);

        if (currentAngle < target - 0.5) {
            useTalon.T_1.set(output);
            useTalon.T_2.set(output);
            System.out.println("angle less than target");

        } else if (currentAngle > target + 0.5) {
            useTalon.T_1.set(-output);
            useTalon.T_2.set(-output);
            System.out.println("angle greater than target");

        } else {
            useTalon.T_1.set(0.0);
            useTalon.T_2.set(0.0);
            System.out.println("angle on target");
            sumError = 0;
        }
    }

    public void SmartDashBoard() {

        SmartDashboard.putNumber("Current Angle", currentAngle);
        System.out.print(ahrs.getAngle());

    }
}
