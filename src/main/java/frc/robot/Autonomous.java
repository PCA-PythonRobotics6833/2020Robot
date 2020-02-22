/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;

public class Autonomous {

  Drivetrain useTalons;
  AutoGyroAction useGyro;
  AutoRobotAction useRobot;
  Timer timer;
  int autoStep;
  AHRS ahrs;

  public Autonomous(AutoGyroAction useGyro, AutoRobotAction useRobot, AHRS ahrs) {

    this.useGyro = useGyro;
    this.useRobot = useRobot;
    this.ahrs = ahrs;
    timer = new Timer();
    autoStep = 0;

  }

  public void StartMid() {

    timer.start();

    useGyro.resetGyro();

    if (autoStep == 0) {

      if (timer.get() < 1) {
        useRobot.DriveForward();
      } else {
        autoStep = 1;
        timer.reset();
        timer.start();
      }
    } else if (autoStep == 1) {

      if (timer.get() < 2) {
        useGyro.rotateToAngle(-90);
      } else {
        autoStep = 2;
        timer.reset();
        timer.start();
        ahrs.reset();
      }
    } else if (autoStep == 2) {

      if (timer.get() < 1.2) {
        useRobot.DriveForward();
      } else {
        autoStep = 3;
        timer.reset();
        timer.start();
      }
    } else if (autoStep == 3) {

      if (timer.get() < 2) {
        useGyro.rotateToAngle(90);
      }

      else {
        autoStep = 4;
        timer.reset();
        timer.start();
      }
    } else if (autoStep == 4) {

      if (timer.get() < 3) {
        useRobot.DriveForwardSlow();

      } else {
        autoStep = 5;
        timer.reset();
        timer.start();
      }
    } else if (autoStep == 5) {

      if (timer.get() > 1) {

        if (timer.get() < 2) {
          useRobot.IntakeShoot();
        } else {
          autoStep = 6;
          timer.reset();
          timer.start();
          ahrs.reset();
          useRobot.IntakeStop();
        }
      }
    } else if (autoStep == 6) {

      if (timer.get() < 1) {
        useRobot.DriveBack();
      } else {
        autoStep = 7;
        timer.reset();
        timer.start();
        ahrs.reset();
      }
    } else if (autoStep == 7) {

      if (timer.get() < 2) {
        useGyro.rotateToAngle(180);
      } else {
        autoStep = 8;
        timer.reset();
        timer.start();
        ahrs.reset();
      }
    } else if (autoStep == 8) {
      if (timer.get() < .5) {
        useRobot.DriveForward();
      } else {
        autoStep = 9;
        timer.reset();
        timer.start();
        ahrs.reset();
      }

    }

  }

  public void StartClose() {

    timer = new Timer();
    autoStep = 0;

    timer.start();

    useGyro.resetGyro();

    if (autoStep == 0) {

      if (timer.get() < 3) {
        useRobot.DriveForwardSlow();
      } else {
        autoStep = 1;
        timer.reset();
        timer.start();
        ahrs.reset();
      }
    } else if (autoStep == 1) {

      if (timer.get() < 1.2) {
        useRobot.IntakeShoot();
      } else {
        autoStep = 2;
        timer.reset();
        timer.start();
        useRobot.IntakeStop();
      }
    } else if (autoStep == 2) {

      if (timer.get() < .5) {
        useRobot.DriveBack();
      } else {
        autoStep = 3;
        timer.reset();
        timer.start();
      }

    } else if (autoStep == 3) {

      if (timer.get() < 2) {
        useGyro.rotateToAngle(180);
      } else {
        autoStep = 4;
        timer.reset();
        timer.start();
      }
    } else if (autoStep == 4) {

      if (timer.get() < 1) {
        useRobot.DriveForward();
      } else {
        autoStep = 5;
        timer.reset();
        timer.start();
        ahrs.reset();
      }
    }
  }

  public void StartFar() {

    timer = new Timer();
    autoStep = 0;

    timer.start();

    useGyro.resetGyro();

    if (autoStep == 0) {

      if (timer.get() < 1) {
        useRobot.DriveForward();
      } else {
        autoStep = 1;
        timer.reset();
        timer.start();
      }
    } else if (autoStep == 1) {

      if (timer.get() < 2) {
        useGyro.rotateToAngle(-90);
      } else {
        autoStep = 2;
        timer.reset();
        timer.start();
        ahrs.reset();
      }
    } else if (autoStep == 2) {

      if (timer.get() < 2.5) {
        useRobot.DriveForward();
      } else {
        autoStep = 3;
        timer.reset();
        timer.start();
      }
    } else if (autoStep == 3) {

      if (timer.get() < 2) {
        useGyro.rotateToAngle(90);
      }

      else {
        autoStep = 4;
        timer.reset();
        timer.start();
      }
    } else if (autoStep == 4) {

      if (timer.get() < 2) {
        useRobot.DriveForwardSlow();

      } else {
        autoStep = 5;
        timer.reset();
        timer.start();
      }
    } else if (autoStep == 5) {

      if (timer.get() > 1) {

        if (timer.get() < 2) {
          useRobot.IntakeShoot();
        } else {
          autoStep = 6;
          timer.reset();
          timer.start();
          ahrs.reset();
          useRobot.IntakeStop();
        }
      }
    } else if (autoStep == 6) {

      if (timer.get() < 1) {
        useRobot.DriveBack();
      } else {
        autoStep = 7;
        timer.reset();
        timer.start();
        ahrs.reset();
      }
    } else if (autoStep == 7) {

      if (timer.get() < 2) {
        useGyro.rotateToAngle(180);
      } else {
        autoStep = 8;
        timer.reset();
        timer.start();
        ahrs.reset();
      }
    } else if (autoStep == 8) {
      if (timer.get() < .5) {
        useRobot.DriveForward();
      } else {
        autoStep = 9;
        timer.reset();
        timer.start();
        ahrs.reset();
      }

    }

  }

  public void DoNothing() {

    useTalons.T_1.set(0);
    useTalons.T_1.set(0);

  }

}
