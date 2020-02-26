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
public class Intake {

    PWMVictorSPX topMotor;
    PWMVictorSPX botMotor;
    Joystick stick;
    double Throttle_value;
    int Throttle_axis = 3;
    double deadzone = .2;
    int Inverter = -1;
    //top = 8, bot = 9
    public Intake(int topPort, int botPort, Joystick controller2) {

        botMotor = new PWMVictorSPX(botPort);
        topMotor = new PWMVictorSPX(topPort);

        stick = controller2;

    }

/*    public void intakeControl() {

        // left trigger /shoot
        if (stick.getRawAxis(2) > .5) {

            botMotor.set(.9);
            topMotor.set(.8);

        }
        // right trigger/ pick up
        else if (stick.getRawAxis(3) > .5) {

            botMotor.set(-.7);
            topMotor.set(-.15);
        }

        // right bumper/all out
        else if (stick.getRawButton(6) == true) {

            botMotor.set(-1);
            topMotor.set(1);

        }

        else if (stick.getRawAxis(5) > .1 || stick.getRawAxis(5) < -.1 ) {

            
            topMotor.set(stick.getRawAxis(5));
        }


        else if (stick.getRawButton(3) == true) {

            botMotor.set(-1);
            topMotor.set(-1);

        }

        else if (stick.getRawAxis(3) < deadzone || stick.getRawAxis(2) < deadzone || stick.getRawButton(8) == false) {

            botMotor.set(0);
            topMotor.set(0);

        }

        else {

            botMotor.set(0);
            topMotor.set(0);

        }

    }
*/
    int counterThing;
    public void NewControl(){
        //bottom motor will be 9
        //top should go into 8
        // left bumper /shoot - lt is 4 button

        if(stick.getRawButton(6) == true){
            //speedy intake? 
            topMotor.set(-1);
            botMotor.set(-1);
 
        } else if(stick.getRawAxis(2) > .5){
            //spit out?
            topMotor.set(.7);
            botMotor.set(-.7);

         } else if(stick.getRawAxis(3) > .3){
            //should be slow intake, is currently very fast intake
            topMotor.set(-1);
            botMotor.set(-.7);
           
        } else if(stick.getRawAxis(5) > .5 || stick.getRawAxis(5) < -.5) {
            //override, only works down. should work going up. 
            counterThing++;
            System.out.println("running code" + counterThing);
            botMotor.set(stick.getRawAxis(5));

        } else {
            topMotor.set(0);
            botMotor.set(0);
         }

        

      
        //right trigger is intake  - rt is 5 button
        //right bumper is fast intake  - rb is 3 
        //right stick is override - stick is 5 


         //test to see what direction each motor is 
        


         


    }

}
