package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.teamcode.control.constants.DriveConstants;
import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;

@Autonomous(name = "PID Test",group = "test")
public class PIDTest extends AlmondLinear {

    public void runOpMode() throws InterruptedException
    {

        hardwareMap();
        setModeRunUsingEncoders();
        double turn = DriveConstants.TICKS_PER_DEGREE * 90;
        initImu();
        waitForStart();
        float original = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
        PIDDrive(-5000,-5000,5000,5000);
        float end = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
        setPowerAll(0);
        while(opModeIsActive()){
            telemetry.addData("Start",original);
            telemetry.addData("End",end);
            telemetry.update();
        }
    }
}