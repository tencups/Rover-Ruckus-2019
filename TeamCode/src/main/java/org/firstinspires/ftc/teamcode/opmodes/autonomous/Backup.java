package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;

@Autonomous(group="auto",name="Back-Up")
public class Backup extends AlmondLinear {
    @Override
    public void runOpMode() throws InterruptedException {
        hardwareMap();
        waitForStart();
        unlatch();

    }
}