/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;

/**
 * Add your docs here.
 */
public class Lift {

    PWMVictorSPX V_1;
    PWMVictorSPX V_2;
    PWMVictorSPX S_1;

    Joystick stick;
    Joystick stick2;

    public Lift(int m1, int m2, int m3, Joystick controller1, Joystick controller2) {

        V_1 = new PWMVictorSPX(m1);
        V_2 = new PWMVictorSPX(m2);
        S_1 = new PWMVictorSPX(m3);

        stick = controller1;
        stick2 = controller2;
    }

    public void liftControl() {

        if (stick.getRawAxis(1) < -.2) {

            V_1.set(-10);
            V_2.set(-10);
        }

        else if (stick.getRawAxis(1) > .2) {

            V_1.set(1);
            V_2.set(1);
        }

        else {

            V_1.set(0);
            V_2.set(0);

        }
    }

    public void lock() {
        if(stick.getRawButton(9) || stick2.getRawButton(9)) {
            S_1.set(1);
        } else {
            S_1.set(0);
        }
\    }

}
