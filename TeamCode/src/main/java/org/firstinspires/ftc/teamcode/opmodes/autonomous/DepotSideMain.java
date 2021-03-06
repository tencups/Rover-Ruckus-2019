package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.control.logging.DataLogThread2;
import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;



@Autonomous(name="Depot Side ",group="auto")
public class DepotSideMain extends AlmondLinear
{

    DataLogThread2 log;
    public void runOpMode() throws InterruptedException
    {

        hardwareMap();
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        teamMarker.setPosition(0.8);
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        waitForStart();
        while (opModeIsActive() && isRunning)
        {
            telemetry.addData("Status","In Start");
            telemetry.update();



            unlatch();

            telemetry.addData("Status","Starting to drive");
            telemetry.update();

            detectorEnable();
            driveToPosition(-100,100,100,-100,1);
            driveToPosition(100,-100,-100,-100,1);
            driveToPosition(-200,-200,-200,-200,1);
            driveToPosition(1000,-1000,-1000,1000, 1);
            driveToPosition(200,200,200,200,1);
            if(detector.isFound()&&detector.getWidth()>40&&detector.getXPosition()<500&&detector.getXPosition()>100)
            {
                detector.disable();
                //adjustment for the robot not strafing properly
                driveToPosition(-500,-500,-500,-500,1);

                driveToPosition(9000,-9000,-9000,9000,1);
                driveToPosition(-1000,1000,1000,-1000,1);
                driveToPosition(1000,1000,1000,1000,1);
                teamMarker.setPosition(0.4);
                sleep(500);
                driveToPosition(1300,1300,1300,1300,1);
                driveToPosition(-1250,-1250,1250,1250,1);
                driveToPosition(500,-500,-500,500,1);
                driveToPosition(5000,5000,5000,5000,1);
                slide.setPower(-1);
                sleep(800);
                slide.setPower(0);


            } else {
                driveToPosition(-1300,-1300,1300,1300,0.5);
                driveToPosition(-1200,-1200,-1200,-1200,1);
                if(detector.isFound()&&detector.getWidth()>40)
                {
                    detector.disable();

                    driveToPosition(7500,-7500,-7500,7500,1);
                    driveToPosition(-1000,1000,1000,-1000,1);
                    driveToPosition(-3000,-3000,-3000,-3000,1);
                    teamMarker.setPosition(0.4);
                    sleep(400);
                    driveToPosition(6000,6000,6000,6000,1);
                    driveToPosition(1300,-1300,-1300,1300,1);
                    driveToPosition(3000,3000,3000,3000,1);
                    slide.setPower(-1);
                    sleep(800);
                    slide.setPower(0);


                } else {
                    detector.disable();

                    driveToPosition(-200,-200,200,200,0.2);
                    driveToPosition(1000,-1000,-1000,1000,1);
                    driveToPosition(-2400,-2400,-2400,-2400,1);
                    driveToPosition(500,500,500,500,0.5);
                    driveToPosition(-1000,1000,1000,-1000,1);
                    driveToPosition(-3000,-3000,-3000,-3000,1);
                    driveToPosition(7000,-7000,-7000,7000,1);
                    teamMarker.setPosition(0.4);
                    sleep(400);
                    driveToPosition(2000,2000,2000,2000,1);
                    driveToPosition(1500,-1500,-1500,1500,1);
                    driveToPosition(8000,8000,8000,8000,1);
                    slide.setPower(-1);
                    sleep(800);
                    slide.setPower(0);

                }

            }



            detector.disable();
            isRunning = false;


        }

    }
}