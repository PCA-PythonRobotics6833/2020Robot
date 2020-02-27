/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.kauailabs.navx.frc.AHRS;

/**
 * Add your docs here.
 */
public class AutoRobotAction {

    Intake useIntake;
    Drivetrain useTalon;
    AHRS ahrs;

    public AutoRobotAction(Intake intake, Drivetrain drivetrain, AHRS ahrs) {

        this.useIntake = intake;
        this.useTalon = drivetrain;
        this.ahrs = ahrs;

    }

    public void IntakeShoot() {

        useIntake.botMotor.set(-.7);
        useIntake.topMotor.set(.7);

    }

    public void IntakePickUp() {

        useIntake.botMotor.set(-.4);
        useIntake.topMotor.set(-.15);

    }

    public void IntakeStop() {

        useIntake.botMotor.set(0.0);
        useIntake.topMotor.set(0.0);

    }

    public void DriveForward() {

        useTalon.T_1.set(-.35);
        useTalon.T_2.set(.35);

    }

    public void DriveForwardSlow() {

        useTalon.T_1.set(-.25);
        useTalon.T_2.set(.25);

    }

    public void DriveBack() {

        useTalon.T_1.set(.35);
        useTalon.T_2.set(-.35);

    }

    public void DriveOff() {

        useTalon.T_1.set(0.0);
        useTalon.T_2.set(0.0);

    }


    double leftDrive = -.2;
    double rightDrive = .2;
    double straightError;
    double straightTarget;
    public double straightCurrentAngle;
    double straightOutput;

    public void driveStraightInit() {
        straightTarget = 0;
    }

    public void driveStraight() {
        straightError = Math.abs(straightTarget - ahrs.getAngle()) / 360;
        System.out.println(ahrs.getAngle());

        straightOutput = .7 * Math.sqrt(straightError);

        if(ahrs.getAngle() < 0.5) {
            //too far to the left
            rightDrive = .33;
            leftDrive = -.27;
            System.out.println("drifting to the left");
        } else if(ahrs.getAngle() > 0.5) {
            //too far to the left
            rightDrive = .27;
            leftDrive = -.33;
            System.out.println("drifting to the right");
        } else {
            rightDrive = .3;
            leftDrive = -.3;
        }

        useTalon.T_1.set(leftDrive);
        useTalon.T_2.set(rightDrive);

    }

    double rightEffector;
    double leftEffector;
    boolean leftSide;
    boolean rightSide;
    public void driveS2() {
        leftDrive = -.4;
        rightDrive = .45;
        if(rightSide) {
            leftEffector = 0;
        } else if(leftSide) {
            rightEffector = 0;
        }

        if(ahrs.getAngle() < 0) {
            //too far to the left
            rightEffector -= .01;
            leftEffector += .01;
            System.out.println("drifting to the left");
            leftSide = true;
        } else if(ahrs.getAngle() > 0) {
            //too far to the left
            leftEffector -= .01;
            rightEffector += .01;
            System.out.println("drifting to the right");
            rightSide = true;
        }

        useTalon.T_1.set(leftDrive + leftEffector);
        useTalon.T_2.set(rightDrive + rightEffector);
    }

}
