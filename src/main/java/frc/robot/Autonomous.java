/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


public class Autonomous {

    Drivetrain useTalons;
    AutoGyroAction useGyro;
    AutoRobotAction useRobot; 

    public Autonomous(AutoGyroAction intAutoGyro, AutoRobotAction intAutoRobot) {

      this.useGyro = intAutoGyro;
      this.useRobot = intAutoRobot; 

    }

    // encoders not usable at the moment, so dont use
    public void DriveStraight() {
        /*
         * a //Value Place Holder if (EncoderInt.left_mag > 10000){
         * 
         * EncoderInt.T_1.set(0.5); EncoderInt.T_2.set(0.5);
         * 
         * }
         * 
         * 
         * 
         */

        
    }

    public void StartLeft(){
/*
        if while angle is less than 90
        do useGyro.rotateToAngle180FromStart();

        then do useRobot.Drive();

        then do useRobot.IntakeShoot();
        */
    }

   

}
