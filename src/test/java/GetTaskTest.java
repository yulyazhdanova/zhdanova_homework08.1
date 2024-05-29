import org.example.Priority;
import org.example.Task;
import org.example.TaskList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tags.Positive;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetTaskTest {

    private TaskList taskList;
    private Task task1;
    private Task task2;
    private Task task3;

    @BeforeEach
    void setUp(){
        task1 = new Task("Task1", "Description1", LocalDate.now().minusDays(1),false, Priority.LOW);
        task2 = new Task("Task2", "Description2", LocalDate.now().minusDays(2),false, Priority.MEDIUM);
        task3 = new Task("Task3", "Description3", LocalDate.now().minusDays(3),false, Priority.HIGH);
        taskList = new TaskList("Tasks list", List.of(task1,task2,task3));
    }


    @Positive
    @Test
    void countTasks(){
        int countTasks = 3;
        assertEquals(countTasks,taskList.numberTask(),"Incorrect numbers of tasks");
    }

    @Positive
    @ParameterizedTest
    @EnumSource(Priority.class)
    void checkTaskByPriority(Priority priority){
        final List<Task> expectedPriority = new ArrayList<>();
        switch (priority){
            case LOW:
                expectedPriority.add(task1);
            break;
            case MEDIUM:
                expectedPriority.add(task2);
            break;
            case HIGH:
                expectedPriority.add(task3);
            break;
        }
        final List<Task> factPriority = taskList.getTaskPriority(priority);
        assertEquals(expectedPriority,factPriority,"Fact priority correct " + priority);
    }

    @Positive
    @Test
    void getUnfinishedTask(){
        task1.setCompleted(true);
        task2.setCompleted(true);
        final List<Task> expectedStatusTasks = List.of(task3);
        final List<Task> factStatusTasks = taskList.getUncompletedTask();
        assertEquals(expectedStatusTasks,factStatusTasks,"Incorrect unfinished task");
    }

    @Positive
    @Test
    void getExpiredTasks(){
        final List<Task> expectedTermTasks = List.of(task1,task2,task3);
        final List<Task> factTermTasks = taskList.getExpiredTask();
        assertEquals(expectedTermTasks,factTermTasks,"Incorrect tasks term");
    }
}
