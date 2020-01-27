/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;



public class Robot extends TimedRobot {
Joystick stick;
drivetrain drivetrain; 

  @Override
  public void robotInit() {

    //not real values, chassis/electrical is not built
    stick = new Joystick(0); 
    drivetrain = new drivetrain(0, 1, 2, 3, stick); 

  }

  
  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
   
  }

 
  @Override
  public void autonomousPeriodic() {
    
  }

 
  @Override
  public void teleopPeriodic() {

    drivetrain.tankDrive();
  }

 
  @Override
  public void testPeriodic() {
  }
}
