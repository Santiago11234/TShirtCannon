package frc.robot.commands;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.Constants.ControllerConstants.Axes;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase{
    private DriveSubsystem drive;
    private OI oi;

    private SlewRateLimiter speedLimiter = new SlewRateLimiter(Constants.RobotInfo.speedRateLimit);
    private SlewRateLimiter rotateLimiter = new SlewRateLimiter(Constants.RobotInfo.rotateRateLimit);
    public DriveCommand(DriveSubsystem drive, OI oi){
        this.drive = drive;
        this.oi = oi;

        addRequirements(drive);
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.arcadeDrive(
        speedLimiter.calculate(oi.getAxis(Constants.IDs.driverController, Axes.LEFT_STICK_Y) * Constants.RobotInfo.driveSpeed),
        rotateLimiter.calculate(oi.getAxis(Constants.IDs.driverController, Axes.RIGHT_STICK_X) * Constants.RobotInfo.rotationSpeed)
    );
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
