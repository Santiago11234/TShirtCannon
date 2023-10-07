// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class IDs{
    public static final int driverController = 0;

    public static final int FrontRightDriveMotor = 0;
    public static final int BackRightDriveMotor = 1;
    public static final int FrontLeftDriveMotor = 2;
    public static final int BackLeftDriveMotor = 3;
    public static final int hopperMotor1 = 4;
    public static final int hopperMotor2 = 5;
    public static final int shooterLeftMotor = 6;
    public static final int shooterRightMotor = 7;
  }
  public static class RobotInfo{
    public static final int speedRateLimit = 12; //Need testing
    public static final int rotateRateLimit = 5; //Need testing

    public static final int shooterMotorLimit = 22; //Need testing

    public static final double driveSpeed = 0.66; //Need testing
    public static final double rotationSpeed = 0.65; //Need testing

    public static final double hopperSpeed = 0.25;
    public static final double shooterIdleSpeed = 0.25;
    
    public static final double closeDistSpeed = 0.5; //Need testing
    public static final double midDistSpeed = 0.75; //Need testing
    public static final double farDistSpeed = 1; //Need testing
  }

  public static class ControllerConstants{
    public static final double DEADZONE_VALUE = 0.01;
    public static final int NUMBER_OF_CONTROLLERS = 2;

    public enum Axes {
      LEFT_STICK_X(0), LEFT_STICK_Y(1), 
      LEFT_TRIGGER(2), RIGHT_TRIGGER(3), 
      RIGHT_STICK_X(4), RIGHT_STICK_Y(5);
  
      private final int value;
  
      Axes(int value) {
        this.value = value;
      }
  
      public int getValue() {
        return value;
      }
    }
  
    public enum Buttons {
      A_BUTTON(1), B_BUTTON(2), X_BUTTON(3), Y_BUTTON(4), LEFT_BUMPER(5), RIGHT_BUMPER(6), BACK_BUTTON(
          7), START_BUTTON(8), LEFT_STICK(9), RIGHT_STICK(10);
  
      private final int value;
  
      private Buttons(int value) {
        this.value = value;
      }
  
      public int getValue() {
        return value;
      }
    }
  }
}
