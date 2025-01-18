package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
//import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
//import com.revrobotics.SparkPIDController;
//import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ManipConstants;;

public class IntakeSubsystem extends SubsystemBase {

    SparkFlex m_intakeMotor = new SparkFlex(ManipConstants.kIntakeMotor, MotorType.kBrushless);
    // private SparkPIDController m_intakePIDController;
    SparkMaxConfig m_sparkMaxIntakeMotorConfig = new SparkMaxConfig();

    public void configIntakeMotor(){
        //m_intakeMotor.restoreFactoryDefaults();
        //m_intakeMotor.setIdleMode(CANSparkBase.IdleMode.kBrake);
        // m_intakePIDController = m_intakeMotor.getPIDController();
        // m_intakePIDController.setP(ManipConstants.kIntakeP);
        // m_intakePIDController.setI(ManipConstants.kIntakeI);
        // m_intakePIDController.setD(ManipConstants.kIntakeD);
        // m_intakePIDController.setFF(ManipConstants.kIntakeFF);
        // m_intakePIDController.setOutputRange(ManipConstants.kIntakeMinOutput, ManipConstants.kIntakeMaxOutput);
        //m_intakeMotor.burnFlash();

                // setup config for m_intermediate
        m_sparkMaxIntakeMotorConfig
            .inverted(true)
            //.smartCurrentLimit(ModuleConstants.kDrivingMotorCurrentLimit)
            .idleMode(IdleMode.kBrake);
        m_intakeMotor.configure(m_sparkMaxIntakeMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    }
    public void noRunIntake(){
        // m_intakePIDController.setReference(0, ControlType.kVelocity);
        m_intakeMotor.set(0);
    }
    public void runIntake(double speed){

        // m_intakePIDController.setReference(0.5, ControlType.kVelocity);
        m_intakeMotor.set(speed);

    }

}
