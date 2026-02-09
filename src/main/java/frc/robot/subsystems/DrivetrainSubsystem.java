package frc.robot.subsystems;


import com.ctre.phoenix6.sim.TalonFXSimState.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase; 

public class DrivetrainSubsystem extends SubsystemBase {

  // Declaração dos motores escovados (NEO)
  private SparkMax MDE = new SparkMax(2, MotorType.kBrushless); // Motor dianteiro esquerdo
  private SparkMax MTD = new SparkMax(4, MotorType.kBrushless); // Motor traseiro direito
  private SparkMax MDD = new SparkMax(5, MotorType.kBrushless); // Motor dianteiro direito
  private SparkMax MTE = new SparkMax(3, MotorType.kBrushless); // Motor traseiro esquerdo

  public void drive(double speed, double rotation, double multiplier, boolean brake) {
    if (!brake) {
      // Se o brake não estiver pressionado calcula e define a velocidade e rotação conforme a multiplicação
      MTE.set(((speed - (rotation / 2.6)) * -multiplier)); 
      MDD.set(((-speed + (-rotation / 2.6)) * -multiplier));  
      MDE.set(((speed - (rotation / 2.6)) * -multiplier));  
      MTD.set(((-speed + (-rotation / 2.6)) * -multiplier));
      // Caso contrário o motor irá ficar em posição estática
    } else {
      MTE.set(0); 
      MDD.set(0);  
      MDE.set(0);  
      MTD.set(0);  
    }
  }
}  