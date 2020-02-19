/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.DriverStation;






public class Robot extends TimedRobot {

//Mechanical
Joystick stick;
Joystick stick2;
Drivetrain drivetrain; 
Intake Intake; 
Lift lift;
ControlPanel intPanel; 

//Programming
NetworkTableInstance table = NetworkTableInstance.getDefault();
Autonomous autoOne; 
AHRS ahrs; 
 double rotateToAngle; 
 double currentAngle; 




  @Override
  public void robotInit() {

    
    stick = new Joystick(0); 
    stick2 = new Joystick(1); 
    drivetrain = new Drivetrain(0,1,2,3,4,5, stick); 
    Intake = new Intake(8,9 , stick2);
    lift = new Lift(0, 1, stick);
    intPanel = new ControlPanel(6,7, stick2);

    //programming
    

    
    /*
    table.startServer();
    table.getEntry("BallDistanceX");
    NetworkTable powercell = table.getTable("powercell");
    */
  
     
    /*
            You need to create these 2 objects in robot:
    public static NetworkTableInstance networkTableInstance = NetworkTableInstance.getDefault();
    public static edu.wpi.first.networktables.NetworkTable networkTable;
    The top one is the Instance and the bottom one is the actual table you are getting you’re data from
    In RobotInit() you need to start your server and assign a keyname to your networktable:
    networkTableInstance.startServer();
    networkTable = networkTableInstance.getTable(“networkTable”);
    Then to actually get values off your networktable you do this where you want to retrieve your value (in this case a double):
    networkTable.getEntry(“desiredValue”).getDouble(defaultValue);
    */

  }

  
  @Override
  public void robotPeriodic() {

   // autoOne.Smartdashboard();
   
    


  }

  @Override
  public void autonomousInit() {


    try {
      /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
      /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
      /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
      ahrs = new AHRS(SPI.Port.kMXP); 
  } catch (RuntimeException ex ) {
      DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
  }

  currentAngle = ahrs.getAngle();

  autoOne = new Autonomous(ahrs); 



   
  }

 
  @Override
  public void autonomousPeriodic() {

  

 
    
  }

 
  @Override
  public void teleopPeriodic() {

   

   

   // lift.liftControl();
    Intake.intakeControl();
    intPanel.PanelControl();

    
    if (stick.getRawButton (2)== true)
    {
      lift.liftControl();
      drivetrain.no();
   
    }
   else 
    {
     drivetrain.TalonDrive();
    }

  }

 
  @Override
  public void testPeriodic() {

  }



}
