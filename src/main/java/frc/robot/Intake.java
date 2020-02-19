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
public class Intake{

    PWMVictorSPX TopMotor;
    PWMVictorSPX BottomMotor; 
    Joystick stick;
    double Throttle_value;
    int Throttle_axis = 3;
    double deadzone = .2; 
    int Inverter = -1;

    public Intake(int bot, int top, Joystick controller2){

        BottomMotor = new PWMVictorSPX(bot);
        TopMotor = new PWMVictorSPX(top);
        
        stick = controller2; 

    }

    public void intakeControl(){

        //old code 

        /*
        Throttle_value = stick.getRawAxis(Throttle_axis);
        WindowMotor.set(stick.getRawAxis(1)/(2-Throttle_value));
        RedLine.set(stick.getRawAxis(5)/(2-Throttle_value)); 
        */
        
        //new code 
         if(stick.getRawAxis(2) > .5){

            BottomMotor.set(-1);
            TopMotor.set(.6);

           // RedLine.set(stick.getRawAxis(2)*Inverter/2);
           // WindowMotor.set(stick.getRawAxis(2)/3); 
        }

       else if(stick.getRawAxis(3) > .5){

  //          RedLine.set(stick.getRawAxis(3)*Inverter/2);
//            WindowMotor.set(stick.getRawAxis(3)*Inverter/3); 

            BottomMotor.set(-.3);
            TopMotor.set(-.4);
        }

       

        else if(stick.getRawButton(5) == true){

            BottomMotor.set(.3);
            TopMotor.set(-.3);

        }

        else if(stick.getRawAxis(3) < deadzone || stick.getRawAxis(2) < deadzone || stick.getRawButton(8) == false){

            BottomMotor.set(0);
            TopMotor.set(0);

        }

        else{

            BottomMotor.set(0);
            TopMotor.set(0);

        }
        
        


    }

}
