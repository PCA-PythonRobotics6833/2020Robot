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
public class Intake {

    PWMVictorSPX TopMotor;
    PWMVictorSPX BottomMotor;
    Joystick stick;
    double Throttle_value;
    int Throttle_axis = 3;
    double deadzone = .2;
    int Inverter = -1;

    public Intake(int bot, int top, Joystick controller2) {

        BottomMotor = new PWMVictorSPX(bot);
        TopMotor = new PWMVictorSPX(top);

        stick = controller2;

    }

    public void intakeControl() {

        // left trigger /shoot
        if (stick.getRawAxis(2) > .5) {

            BottomMotor.set(.9);
            TopMotor.set(.8);

        }
        // right trigger/ pick up
        else if (stick.getRawAxis(3) > .5) {

            BottomMotor.set(-.7);
            TopMotor.set(-.15);
        }

        // right bumper/all out
        else if (stick.getRawButton(6) == true) {

            BottomMotor.set(-1);
            TopMotor.set(1);

        }

        else if (stick.getRawAxis(5) > .1 || stick.getRawAxis(5) < -.1 ) {

            
            TopMotor.set(stick.getRawAxis(5));
        }


        else if (stick.getRawButton(3) == true) {

            BottomMotor.set(-1);
            TopMotor.set(-1);

        }

        else if (stick.getRawAxis(3) < deadzone || stick.getRawAxis(2) < deadzone || stick.getRawButton(8) == false) {

            BottomMotor.set(0);
            TopMotor.set(0);

        }

        else {

            BottomMotor.set(0);
            TopMotor.set(0);

        }

    }

}
