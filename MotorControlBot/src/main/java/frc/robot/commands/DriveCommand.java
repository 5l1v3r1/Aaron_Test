package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveCommand extends Command {
    private final DriveTrainSubsystem driveTrainSubsystem;
    private final JoystickButton button;

    public DriveCommand(DriveTrainSubsystem driveTrainSubsystem, JoystickButton button) {
        requires(driveTrainSubsystem);
        this.driveTrainSubsystem = driveTrainSubsystem;
        this.button = button;
    }

    @Override
    protected void initialize() {
        // Called once before the Command is executed
        // Reset any counters here
    }

    @Override
    protected void execute() {
        // Called repeatedly when this Command is scheduled to run
        driveTrainSubsystem.setVictorToMax();
    }

    @Override
    protected boolean isFinished() {
        // This does the same thing as the one line below

//        if (this.button.get()){
//            return false;
//        }
//        else{
//            return true;
//        }
        return !this.button.get();
    }

    @Override
    protected void end() {
        // Called once isFinished returns 'true'
    }

    @Override
    protected void interrupted() {
        // Called when another command which requires one
        // or more of the same subsystems is scheduled to run

        // Usually just end the command here, although it is
        // a case by case scenario

        end();
    }
}
