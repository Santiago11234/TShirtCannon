package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase{
    private CANSparkMax left;
    private CANSparkMax right;
    
    public ShooterSubsystem(){
        left = new CANSparkMax(Constants.IDs.shooterLeftMotor, MotorType.kBrushless);
        right = new CANSparkMax(Constants.IDs.shooterRightMotor, MotorType.kBrushless);

        left.restoreFactoryDefaults();
        right.restoreFactoryDefaults();

        left.setIdleMode(IdleMode.kCoast);
        right.setIdleMode(IdleMode.kCoast);

        left.setInverted(false);
        right.setInverted(true);

        left.setSmartCurrentLimit(Constants.RobotInfo.shooterMotorLimit);
        right.setSmartCurrentLimit(Constants.RobotInfo.shooterMotorLimit);

        left.clearFaults();
        right.clearFaults();
    }

    public void setSpeed(double speed){
        left.set(speed);
        right.set(speed);
    }

    public void stop(){
        left.stopMotor();
        right.stopMotor();
    }
}
