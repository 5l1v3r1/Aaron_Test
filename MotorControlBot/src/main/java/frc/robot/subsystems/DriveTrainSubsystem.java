package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrainSubsystem extends Subsystem {
    // Only make the hardware components 'final'
    private final Talon talon01;

    // All other variables should not be final because they may
    // not have been initialized.
    private Command command;

    public DriveTrainSubsystem(Talon talon, Command command) {
        if (talon == null) {
            throw new IllegalArgumentException("Please use a talon motor controller");
        }
        this.talon01 = talon;
        this.command = command;
    }

    public DriveTrainSubsystem(Talon talon) {
        if (talon == null) {
            throw new IllegalArgumentException("Please use a talon motor controller");
        }
        this.talon01 = talon;
    }

    public DriveTrainSubsystem() {
        throw new IllegalAccessError("Only construct this subsystem with all its dependencies");

    }

    public void setTalonsToMax() {
        this.talon01.setSpeed(1.0);
    }

    @Override
    public void initDefaultCommand() {
        // TODO set the default Command
        // setDefaultCommand(new Command());
        setDefaultCommand(this.command);
    }
}

