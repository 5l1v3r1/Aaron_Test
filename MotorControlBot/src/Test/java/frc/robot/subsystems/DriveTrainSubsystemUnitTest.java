package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.SchedulerTestHelper;
import frc.robot.commands.DriveCommand;
import org.junit.jupiter.api.*;


import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;

public class DriveTrainSubsystemUnitTest {
    private static SchedulerTestHelper schedulerTestHelper;

    /**
     * Before a test starts, wire up the command scheduler to run
     * our scheduled command every 20 milliseconds
     * (what WPILib will do, I believe)
     */
    @BeforeAll
    public static void setupSchedulerHelper() {
        schedulerTestHelper = new SchedulerTestHelper(20);
    }

    /**
     * When a test finishes, tear down the scheduler, because it uses threading
     * to do its work, and if you do not tear it down, the test runner will never
     * terminate.
     */
    @AfterAll
    static void cleanUpSchedulerHelper() {
        schedulerTestHelper.destroy();
    }

    /**
     * A test that checks that the command will turn on the LED within the
     * hello world subsystem the requisite number of times once run
     * under the scheduler. Exceptions can be thrown by the scheduler
     * and if they are, then the test will fail. That's fine. One test
     * success criteria is defined by the Test decorator parameter that
     * says we should not exit the method with anything on the stack
     * (an exception, for example).
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */

    @Test
    protected void canSetVictorSpeedToMax() throws InterruptedException, ExecutionException {
        // Assemble
        System.out.println("Passed");
        VictorSPX victorSPX_01 = mock(VictorSPX.class);
        System.out.println("Mock Talon Created");
        // Note that we do not mock the subsystem because we are going to test the result
        // on the subsystem by exercising behavior on the command
        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem(victorSPX_01);
        System.out.println("DriveTrainSubsystem created");

        DriveCommand driveCommand = new DriveCommand(classUnderTest);
        System.out.println("DriveCommand initiated");

        //Act
        schedulerTestHelper.run(driveCommand).forDuration(7);

        //Assert
        verify(victorSPX_01, atLeastOnce()).set(ControlMode.PercentOutput, 1);
        verifyNoMoreInteractions(victorSPX_01);
    }
}
