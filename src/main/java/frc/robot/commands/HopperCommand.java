package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.HopperSubsystem;

public class HopperCommand extends CommandBase{
    private HopperSubsystem hopper;
    private OI oi;

    public HopperCommand(HopperSubsystem hopper, OI oi){
        this.hopper = hopper;
        this.oi = oi;

        addRequirements(hopper);
    }
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        hopper.setSpeed(0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if(oi.getButton(Constants.IDs.driverController, Constants.ControllerConstants.Buttons.RIGHT_BUMPER).getAsBoolean()){
            hopper.setSpeed(Constants.RobotInfo.hopperSpeed);
        }
        else if(oi.getButton(Constants.IDs.driverController, Constants.ControllerConstants.Buttons.LEFT_BUMPER).getAsBoolean()){
            hopper.setSpeed(-Constants.RobotInfo.hopperSpeed);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
