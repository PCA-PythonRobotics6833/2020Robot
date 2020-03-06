/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class ControlPanel {

    WPI_TalonSRX Window;
    WPI_TalonSRX Red;

    Joystick stick;

    public ControlPanel(int m_1, int m_2, Joystick controller1) {

        Window = new WPI_TalonSRX(m_1);
        Red = new WPI_TalonSRX(m_2);

        stick = controller1;

    }

    public void PanelControl() {

        if (stick.getRawButton(2) == true) {

            Window.set(-.3);

        }

        else if (stick.getRawButton(1) == true) {

            Red.set(-1);
        }

        else {

            Window.set(0);
            Red.set(0);
        }

    }

}
