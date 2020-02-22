/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class AutoRobotAction {

    Intake useIntake;
    Drivetrain useTalon;

    public AutoRobotAction(Intake intake, Drivetrain drivetrain) {

        this.useIntake = intake;
        this.useTalon = drivetrain;

    }

    public void IntakeShoot() {

        useIntake.BottomMotor.set(-.7);
        useIntake.TopMotor.set(.7);

    }

    public void IntakePickUp() {

        useIntake.BottomMotor.set(-.7);
        useIntake.TopMotor.set(-.7);

    }

    public void IntakeStop() {

        useIntake.BottomMotor.set(0.0);
        useIntake.TopMotor.set(0.0);

    }

    public void DriveForward() {

        useTalon.T_1.set(-.4);
        useTalon.T_2.set(.45);

    }

    public void DriveForwardSlow() {

        useTalon.T_1.set(-.3);
        useTalon.T_2.set(.35);

    }

    public void DriveBack() {

        useTalon.T_1.set(.3);
        useTalon.T_2.set(-.35);

    }

    public void DriveOff() {

        useTalon.T_1.set(0.0);
        useTalon.T_2.set(0.0);

    }

}
