package frc.robot.commands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.Constants;
import frc.robot.OI;

public class ShooterCommand extends CommandBase{
    private ShooterSubsystem shooter;
    private HopperSubsystem hopper;
    private OI oi;

    public ShooterCommand(ShooterSubsystem shooter, HopperSubsystem hopper, OI oi){
        this.shooter = shooter;
        this.hopper = hopper;
        this.oi = oi;

        addRequirements(shooter);
    }
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        shooter.setSpeed(0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if(oi.getButton(Constants.IDs.driverController, Constants.ControllerConstants.Buttons.X_BUTTON).getAsBoolean()){
            hopper.setSpeed(Constants.RobotInfo.hopperSpeed);
            shooter.setSpeed(Constants.RobotInfo.closeDistSpeed);
        }
        else if(oi.getButton(Constants.IDs.driverController, Constants.ControllerConstants.Buttons.Y_BUTTON).getAsBoolean()){
            hopper.setSpeed(Constants.RobotInfo.hopperSpeed);
            shooter.setSpeed(Constants.RobotInfo.midDistSpeed);
            
        }
        else if(oi.getButton(Constants.IDs.driverController, Constants.ControllerConstants.Buttons.B_BUTTON).getAsBoolean()){
            hopper.setSpeed(Constants.RobotInfo.hopperSpeed);
            shooter.setSpeed(Constants.RobotInfo.farDistSpeed);
        }
        else{
            shooter.setSpeed(Constants.RobotInfo.shooterIdleSpeed);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
