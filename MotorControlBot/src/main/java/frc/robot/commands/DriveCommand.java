package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveCommand extends Command {
    private final DriveTrainSubsystem driveTrainSubsystem;

    public DriveCommand(DriveTrainSubsystem driveTrainSubsystem) {
        requires(driveTrainSubsystem);
        this.driveTrainSubsystem = driveTrainSubsystem;
    }

    @Override
    protected void initialize() {
        // Called once before the Command is executed
        // Reset any counters here
    }

    @Override
    protected void execute() {
        // Called repeatedly when this Command is scheduled to run
        driveTrainSubsystem.setTalonsToMax();
    }

    @Override
    protected boolean isFinished() {
        // TODO write condition for stopping command
       return false;
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
