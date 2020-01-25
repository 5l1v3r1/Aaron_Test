package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrainSubsystem extends Subsystem {
    // Only make the hardware components 'final'
    private final VictorSPX victorSPX_01;

    // All other variables should not be final because they may
    // not have been initialized.

    public DriveTrainSubsystem(VictorSPX victorSPX) {
        if (victorSPX == null) {
            throw new IllegalArgumentException("Please use a Victor SPX motor controller");
        }
        this.victorSPX_01 = victorSPX;
    }

    public DriveTrainSubsystem() {
        throw new IllegalAccessError("Only construct this subsystem with all its dependencies");

    }

    public void setVictorToMax() {
        this.victorSPX_01.set(ControlMode.PercentOutput, 1);
    }

    public void setVictorToZero() {
        this.victorSPX_01.set(ControlMode.PercentOutput, 0);
    }

    @Override
    protected void initDefaultCommand() {
    }
}

