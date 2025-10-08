package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends TimedRobot {
    private PWMSparkMax leftDriveMotor = new PWMSparkMax(0);
    private PWMSparkMax rightDriveMotor = new PWMSparkMax(1);
    private Timer timer = new Timer();

    private Joystick joystick = new Joystick(0); // Make sure you actually have this plugged in

    @Override
    public void robotInit() {
        rightDriveMotor.setInverted(true);
    }

    @Override
    public void autonomousInit() {
        timer.reset();
        timer.start();
    }

    @Override
    public void autonomousPeriodic() {
        double time = timer.get();

        // Drive forward for 2 seconds
        if (time < 2.0) {
            leftDriveMotor.set(0.5);
            rightDriveMotor.set(0.5);
        } 
        // Turn right for 1 second
        else if (time < 3.0) {
            leftDriveMotor.set(0.5);
            rightDriveMotor.set(-0.5);
        }
        // Drive backward for 2 seconds
        else if (time < 5.0) {
            leftDriveMotor.set(-0.5);
            rightDriveMotor.set(-0.5);
        } 
        // Stop
        else {
            leftDriveMotor.set(0.0);
            rightDriveMotor.set(0.0);
        }
    }

    @Override
    public void teleopPeriodic() {
        double forward = -joystick.getY(); // usually forward is negative Y
        double turn = joystick.getX();

        double leftPower = forward + turn;
        double rightPower = forward - turn;

        leftDriveMotor.set(leftPower);
        rightDriveMotor.set(rightPower);
    }
}
