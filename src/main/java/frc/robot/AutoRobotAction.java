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

    public AutoRobotAction(Intake intake, Drivetrain drivetrain){

        this.useIntake = intake; 
        this.useTalon = drivetrain; 

    }


    public void IntakeShoot(){

        useIntake.BottomMotor.set(.7);
        useIntake.TopMotor.set(.7);

    }

    public void IntakePickUp(){

        useIntake.BottomMotor.set(.7);
        useIntake.TopMotor.set(-.7);


    }

    public void Drive(){

        useTalon.T_1.set(.5);
        useTalon.T_2.set(.5);

    }

    
}
