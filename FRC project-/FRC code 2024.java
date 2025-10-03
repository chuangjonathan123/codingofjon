package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Robot extends TimedRobot {
    private PWMSparkMax leftMotor = new PWMSparkMax(0);
    private PWMSparkMax rightMotor = new PWMSparkMax(1);

    private Timer timer = new Timer();

    @Override
    public void robotInit() {
        rightMotor.setInverted(true);
    }

    @Override
    public void autonomousInit() {
        timer.reset();
        timer.start();
    }

    @Override
    public void autonomousPeriodic() {
        if (timer.get() < 2.0) {
            leftMotor.set(0.5);
            rightMotor.set(0.5);
        } else {
            leftMotor.set(0.0);
            rightMotor.set(0.0);
        }
    }

   
    @Override
    public void teleopPeriodic() {
      double forward = joystick.getY();   
      double turn = joystick.getX();      
  
      leftMotor.set(forward + turn);
      rightMotor.set(forward - turn);
  }

}
