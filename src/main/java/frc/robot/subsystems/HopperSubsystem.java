package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class HopperSubsystem extends SubsystemBase{
    private WPI_VictorSPX motor1;
    private WPI_VictorSPX motor2;

    public HopperSubsystem(){
        motor1 = new WPI_VictorSPX(Constants.IDs.hopperMotor1);
        motor2 = new WPI_VictorSPX(Constants.IDs.hopperMotor2);

        motor1.configFactoryDefault();
        motor2.configFactoryDefault();

        motor1.setNeutralMode(NeutralMode.Brake);
        motor2.setNeutralMode(NeutralMode.Brake);
    }

    public void setSpeed(double speed){
        motor1.set(speed);
        motor2.set(speed);
    }

    public void stop(){
        motor1.stopMotor();
        motor2.stopMotor();
    }
}
