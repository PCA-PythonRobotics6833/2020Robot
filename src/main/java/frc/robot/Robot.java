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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class Robot extends TimedRobot {

  // Mechanical
  Joystick stick;
  Joystick stick2;
  Drivetrain drivetrain;
  Intake intake;
  Lift lift;
  ControlPanel cPanel;

  // Programming
  NetworkTableInstance table = NetworkTableInstance.getDefault();
  AHRS ahrs;
  double rotateToAngle;
  double currentAngle;
  AutoGyroAction useGyro;
  AutoRobotAction useRobot;
  Autonomous useAuto;

  // auto
  SendableChooser<String> autoChooser = new SendableChooser<>();
  int startingPosition;
  String Close;
  String Mid;
  String Far;
  String DoNothing;
  String Test;
  Timer timer;

  @Override
  public void robotInit() {

    stick = new Joystick(0);
    stick2 = new Joystick(1);
    drivetrain = new Drivetrain(0, 1, 2, 3, 4, 5, stick);
    intake = new Intake(9, 8, stick2);
    lift = new Lift(0, 1, stick2);
    cPanel = new ControlPanel(6, 7, stick2);
    timer = new Timer();

    // programming
    ahrs = new AHRS(SPI.Port.kMXP);
    useGyro = new AutoGyroAction(ahrs, drivetrain);
    useRobot = new AutoRobotAction(intake, drivetrain, ahrs);
    useAuto = new Autonomous(useGyro, useRobot, ahrs, timer);

    autoChooser.addOption("Start Close", "Start Close");
    autoChooser.addOption("Start Mid", "Start Mid");
    autoChooser.addOption("Start Far", "Start Far");
    autoChooser.addOption("Test", "Test");
    autoChooser.addOption("Drive Straight", "Drive Straight");
  //  autoChooser.addOption("Do Nothing", "Do Nothing");
    autoChooser.setDefaultOption("Do Nothing", "Do Nothing");

    
    SmartDashboard.putData(autoChooser);
    /*
     * table.startServer(); table.getEntry("BallDistanceX"); NetworkTable powercell
     * = table.getTable("powercell");
     */

    /*
     * You need to create these 2 objects in robot: public static
     * NetworkTableInstance networkTableInstance =
     * NetworkTableInstance.getDefault(); public static
     * edu.wpi.first.networktables.NetworkTable networkTable; The top one is the
     * Instance and the bottom one is the actual table you are getting you’re data
     * from In RobotInit() you need to start your server and assign a keyname to
     * your networktable: networkTableInstance.startServer(); networkTable =
     * networkTableInstance.getTable(“networkTable”); Then to actually get values
     * off your networktable you do this where you want to retrieve your value (in
     * this case a double):
     * networkTable.getEntry(“desiredValue”).getDouble(defaultValue);
     */

  }

  @Override
  public void disabledPeriodic() {

    //useRobot.DriveOff();

  }

  @Override
  public void robotPeriodic() {


  }

  @Override
  public void autonomousInit() {
    useAuto.TestDriveStraightInit();
    useAuto.resetStep();

    if (autoChooser.getSelected() == ("Start Close")) {
      startingPosition = 1;
    } else if (autoChooser.getSelected() == ("Start Mid")) {
      startingPosition = 2;
    } else if (autoChooser.getSelected() == ("Start Far")) {
      startingPosition = 3;
    } else if (autoChooser.getSelected() == ("Do Nothing")) {
      startingPosition = 4;
    } else if (autoChooser.getSelected() == ("Test")) {
      startingPosition = 5;
    } else if (autoChooser.getSelected() == ("Drive Straight")) {
      startingPosition = 6;
    }



    useGyro.resetGyro();
    timer.start();
  }

  @Override
  public void autonomousPeriodic() {
    System.out.println("startingposition " + startingPosition);

    switch (startingPosition) {
      case (1):
        System.out.println("close");
        useAuto.StartClose();
        break;
      case (2):
        System.out.println("mid");
        useAuto.StartMid();
        break;
      case (3):
        System.out.println("far");
        useAuto.StartFar();
        break;
      case (4):
        System.out.println("nothing");
        useAuto.DoNothing();
        break;
      case (5):
        System.out.println("Testing");
        useAuto.Test();
        break;
      case (6):
        System.out.println("drive straight");
        useAuto.TestDriveStraight();
      }

  }

  @Override
  public void teleopPeriodic() {

    lift.liftControl();
    intake.intakeControl();
    cPanel.PanelControl();
    drivetrain.TalonDrive();

    if (stick.getRawAxis(2) > .5) {
      drivetrain.TalonDriveNoLimiter();

    } else {
      drivetrain.TalonDrive();
    }

  }

  @Override
  public void testPeriodic() {

  }

}
