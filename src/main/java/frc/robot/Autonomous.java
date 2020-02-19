/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//for navx gyro
import com.kauailabs.navx.frc.AHRS;




public class Autonomous {


 AHRS ahrs; 
 double rotateToAngle; 
 double currentAngle; 
 Drivetrain drivetrain;



     public Autonomous(AHRS ahrs){

        
     this.ahrs = ahrs; 
        

    }

    public void NavxGyro(){

        if(currentAngle > (rotateToAngle+.5)){

            //move robot a certain way code right now

        }

        else if(currentAngle <(rotateToAngle-.5)){

            //moves robot other way if it over shoots

        }

        else{

            //robot not move 

        }

    }
    public void Smartdashboard(){
     
        //SmartDashboard.putNumber("Current Angle", currentAngle);
        System.out.print(ahrs.getAngle());




    }



    
}
