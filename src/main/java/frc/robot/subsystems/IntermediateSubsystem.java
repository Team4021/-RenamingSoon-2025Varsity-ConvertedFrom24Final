package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ManipConstants;

public class IntermediateSubsystem extends SubsystemBase{

    SparkMax m_intermediate = new SparkMax(ManipConstants.kIntermediate, MotorType.kBrushless);
    SparkMax m_intermediate2 = new SparkMax(ManipConstants.kIntermediate2, MotorType.kBrushless);
    SparkMaxConfig m_sparkMaxIntermediateConfig = new SparkMaxConfig();
    SparkMaxConfig m_sparkMaxIntermediate2Config = new SparkMaxConfig();

    public void configIntermediateMotors(){
        //m_intermediate.restoreFactoryDefaults();
        //m_intermediate2.restoreFactoryDefaults();

        //put configs here
        //m_intermediate.setIdleMode(IdleMode.kBrake);
        //m_intermediate2.setIdleMode(IdleMode.kBrake);

        //m_intermediate.burnFlash();
        //m_intermediate2.burnFlash();
        
        // setup config for m_intermediate
        m_sparkMaxIntermediateConfig
            .inverted(true)
            //.smartCurrentLimit(ModuleConstants.kDrivingMotorCurrentLimit)
            .idleMode(IdleMode.kBrake);

        // setup config for m_intermediate2
        m_sparkMaxIntermediate2Config
            .inverted(true)
            //.smartCurrentLimit(ModuleConstants.kDrivingMotorCurrentLimit)
            .idleMode(IdleMode.kBrake);
        
        m_intermediate.configure(m_sparkMaxIntermediateConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        m_intermediate2.configure(m_sparkMaxIntermediate2Config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    }

    public void noRunIntermediate(){

        m_intermediate.set(0);
        m_intermediate2.set(0);

    }

    public void runIntermediate(double speed){

        m_intermediate.set(speed);
        m_intermediate2.set(-speed);
        
    }
    
}
