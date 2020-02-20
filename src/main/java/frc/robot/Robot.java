/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
//import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.DriverStation;

public class Robot extends TimedRobot {

  //variables for auto commands
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();


  // Mechanical
  Joystick stick;
  Joystick stick2;
  Drivetrain drivetrain;
  Intake Intake;
  Lift lift;
  ControlPanel intPanel;

  // Programming
  NetworkTableInstance table = NetworkTableInstance.getDefault();
  AHRS ahrs;
  double rotateToAngle;
  double currentAngle;
  AutoGyroAction intAutoTest;

  @Override
  public void robotInit() {

    //put auto options 
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    stick = new Joystick(0);
    stick2 = new Joystick(1);
    drivetrain = new Drivetrain(0, 1, 2, 3, 4, 5, stick);
    Intake = new Intake(9, 8, stick2);
    lift = new Lift(0, 1, stick2);
    intPanel = new ControlPanel(6, 7, stick2);

    CameraServer.getInstance().startAutomaticCapture(0);

    // programming
    try {
      /* Communicate w/navX-MXP via the MXP SPI Bus. */
      /* Alternatively: I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB */
      /*
       * See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for
       * details.
       */
      ahrs = new AHRS(SPI.Port.kMXP);
    } catch (RuntimeException ex) {
      DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
    }

    intAutoTest = new AutoGyroAction(ahrs, drivetrain);

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
  public void robotPeriodic() {

    intAutoTest.SmartDashBoard();
    drivetrain.SmartDashboard();

  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {

  //  intAutoTest.rotateToAngleTest();

    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

    // addsequential

  }

  @Override
  public void teleopPeriodic() {

    lift.liftControl();
    Intake.intakeControl();
    intPanel.PanelControl();
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
