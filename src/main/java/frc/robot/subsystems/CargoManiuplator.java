/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Used for intaking and scoring Cargo
 */
public class CargoManiuplator extends Subsystem {

  public final double SPIN_IN_SPEED = 0.50;
  public final double SPIN_OUT_SPEED = -0.75;
  public final double REVERSE_IN_SPEED = -0.50;
  public final double REVERSE_OUT_SPEED = 0.75;
  public final double STOP_SPEED = 0.00;
  
  public WPI_VictorSPX cargoManipulatorMotorLeft = new WPI_VictorSPX(RobotMap.cargoManipulatorPortLeft);

  public WPI_VictorSPX cargoManipulatorMotorRight = new WPI_VictorSPX(RobotMap.cargoManipulatorPortRight);

  public CargoManiuplator() {

    cargoManipulatorMotorRight.setNeutralMode(NeutralMode.Brake);

    cargoManipulatorMotorRight.setInverted(true);
    
    cargoManipulatorMotorLeft.setNeutralMode(NeutralMode.Brake);

    cargoManipulatorMotorRight.setInverted(true);

  }
  

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  // allows the robot to intake cargo
  public void spinCargoManipulatorIn() {
    cargoManipulatorMotorRight.set(ControlMode.PercentOutput, SPIN_IN_SPEED);
    cargoManipulatorMotorLeft.set(ControlMode.PercentOutput, REVERSE_IN_SPEED);
  }

  // allows the robot to score cargo
  public void spinCargoManipulatorOut() {
    cargoManipulatorMotorRight.set(ControlMode.PercentOutput, SPIN_OUT_SPEED);
    cargoManipulatorMotorLeft.set(ControlMode.PercentOutput, REVERSE_OUT_SPEED);
  }
  
  // stops the CargoManipulator 
  public void stopCargoManipulatorMotor() {
    cargoManipulatorMotorRight.set(ControlMode.PercentOutput, STOP_SPEED);
    cargoManipulatorMotorLeft.set(ControlMode.PercentOutput, STOP_SPEED);
  }
}
