package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{
    private WPI_TalonFX frontRight = new WPI_TalonFX(Constants.IDs.FrontRightDriveMotor);
    private WPI_TalonFX backRight = new WPI_TalonFX(Constants.IDs.BackRightDriveMotor);
    private WPI_TalonFX frontLeft = new WPI_TalonFX(Constants.IDs.FrontLeftDriveMotor);
    private WPI_TalonFX backLeft = new WPI_TalonFX(Constants.IDs.BackLeftDriveMotor);

    private DifferentialDrive drive;
    public DriveSubsystem(){
        frontRight.configFactoryDefault();
        backRight.configFactoryDefault();
        frontLeft.configFactoryDefault();
        backLeft.configFactoryDefault();

        frontRight.setNeutralMode(NeutralMode.Brake);
        backRight.setNeutralMode(NeutralMode.Brake);
        frontLeft.setNeutralMode(NeutralMode.Brake);
        backLeft.setNeutralMode(NeutralMode.Brake);

        backRight.follow(frontRight);
        backLeft.follow(frontLeft);

        drive = new DifferentialDrive(frontRight, frontLeft);
        drive.setSafetyEnabled(false);
    }

    public void arcadeDrive(double speed, double rotation){
        drive.arcadeDrive(speed, rotation);
    }
    
    public void stop(){
        drive.stopMotor();
    }
}
