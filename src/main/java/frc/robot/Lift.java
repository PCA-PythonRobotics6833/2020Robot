/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;

/**
 * Add your docs here.
 */
public class Lift {

PWMVictorSPX V_1;
PWMVictorSPX V_2;

Joystick stick; 

    public Lift(int m1, int m2, Joystick controller1){

         V_1 = new PWMVictorSPX(m1);
         V_2 = new PWMVictorSPX(m2);

         stick = controller1; 
    }

    public void liftControl(){

/*
        if(stick.getRawButtonPressed(4)){

            V_1.set(.3);
            V_2.set(.3); 
            
        }

        if(stick.getRawButtonPressed(5)){

            V_1.set(-.3);
            V_2.set(-.3); 
            
        }
*/

        if(stick.getRawButton(5) == true){

            V_1.set(-.7);
            V_2.set(-.7); 
        }

        else if(stick.getRawButton(6) == true){

            V_1.set(.7);
            V_2.set(.7); 
        }

        else{

            V_1.set(0);
            V_2.set(0); 

        }



    }


}
