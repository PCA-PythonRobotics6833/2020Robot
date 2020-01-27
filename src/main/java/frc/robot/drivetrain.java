/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class drivetrain {

    PWMVictorSPX m_1;
    PWMVictorSPX m_2;
    PWMVictorSPX m_3;
    PWMVictorSPX m_4;

    Joystick stick;

    DifferentialDrive myDrive; 

    double Throttle_value;
    int Throttle_axis = 3; 

    double  left_stick;
    double  right_stick;
    
    public drivetrain(int left1, int left2, int right1, int right2, Joystick controller1){

        m_1 = new PWMVictorSPX(left1);
        m_2 = new PWMVictorSPX(left2);
        m_3 = new PWMVictorSPX(right1);
        m_4 = new PWMVictorSPX(right2);

        stick = controller1;
        

        SpeedControllerGroup left_group = new SpeedControllerGroup(m_1, m_2);
        SpeedControllerGroup right_group = new SpeedControllerGroup(m_3, m_4);

        myDrive = new DifferentialDrive(left_group, right_group);


    }

    public void tankDrive(){

        Throttle_value = stick.getRawAxis(Throttle_axis); 

        left_stick = (-stick.getRawAxis(1)/(2-Throttle_value));
        right_stick = (-stick.getRawAxis(5)/(2-Throttle_value));

        myDrive.tankDrive(left_stick, right_stick);
    }

}
