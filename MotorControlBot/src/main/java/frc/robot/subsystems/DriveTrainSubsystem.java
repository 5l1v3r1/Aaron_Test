package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.ColorSensorV3;

public class DriveTrainSubsystem extends Subsystem {
    // Only make the hardware components 'final'
    private final VictorSPX victorSPX_01;

    // All other variables should not be final because they may
    // not have been initialized.
    private Command command;

    public DriveTrainSubsystem(VictorSPX victorSPX, Command command) {
        if (victorSPX == null) {
            throw new IllegalArgumentException("Please use a Victor SPX motor controller");
        }
        this.victorSPX_01 = victorSPX;
        this.command = command;
    }

    public DriveTrainSubsystem(VictorSPX victorSPX) {
        if (victorSPX == null) {
            throw new IllegalArgumentException("Please use a talon motor controller");
        }
        this.victorSPX_01 = victorSPX;
    }

    public DriveTrainSubsystem() {
        throw new IllegalAccessError("Only construct this subsystem with all its dependencies");

    }

    public void setVictorToMax() {
        this.victorSPX_01.set(ControlMode.PercentOutput, 1);
    }

    @Override
    public void initDefaultCommand() {
        // TODO set the default Command
        // setDefaultCommand(new Command());
        setDefaultCommand(this.command);
    }
}

