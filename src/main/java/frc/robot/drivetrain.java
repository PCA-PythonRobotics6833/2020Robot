/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class Drivetrain {

    WPI_TalonSRX T_1;
    WPI_TalonSRX T_2;
    WPI_VictorSPX V_1;
    WPI_VictorSPX V_2;
    WPI_VictorSPX V_3;
    WPI_VictorSPX V_4;

    Joystick stick;

    DifferentialDrive myDrive;

    double Throttle_value;
    int Throttle_axis = 3;

    double left_stick;
    double right_stick;

    double left_mag;
    double right_mag;

    public Drivetrain(int m1, int m2, int m3, int m4, int m5, int m6, Joystick controller1) {

        T_1 = new WPI_TalonSRX(m1);
        T_2 = new WPI_TalonSRX(m4);
        V_1 = new WPI_VictorSPX(m2);
        V_2 = new WPI_VictorSPX(m3);
        V_3 = new WPI_VictorSPX(m5);
        V_4 = new WPI_VictorSPX(m6);

        stick = controller1;

        V_1.follow(T_1);
        V_2.follow(T_1);
        V_3.follow(T_2);
        V_4.follow(T_2);

        myDrive = new DifferentialDrive(T_1, T_2);

    }

    public void TalonDrive() {

        Throttle_value = stick.getRawAxis(Throttle_axis);

        left_stick = (stick.getRawAxis(1) / (2 - Throttle_value));
        right_stick = (stick.getRawAxis(5) / (2 - Throttle_value));

        myDrive.tankDrive(left_stick, right_stick);

    }

    public void TalonDriveNoLimiter() {

        myDrive.tankDrive(stick.getRawAxis(1) * 10, stick.getRawAxis(5) * 10);

    }

    public void MagEncoder() {

        T_1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        T_2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

        this.left_mag = (T_1.getSelectedSensorVelocity(0));
        this.right_mag = (T_2.getSelectedSensorVelocity(0));

    }

    public void SmartDashboard() {

        SmartDashboard.putNumber("left", left_mag);
        SmartDashboard.putNumber("left", right_mag);

    }

}
