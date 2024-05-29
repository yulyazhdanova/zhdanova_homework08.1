import org.example.Priority;
import org.example.Task;
import org.example.TaskList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tags.Negative;
import tags.Positive;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTaskTest {

    private TaskList taskList;

    @BeforeEach
    void setUp(){
        taskList = new TaskList("Новый список задач");
    }

    private static List<Task> createCorrectList(){
        return List.of(
                new Task("Task1","Transaction Task",LocalDate.now().plusDays(2),false, Priority.LOW),
                new Task("Task2",null, LocalDate.now().minusDays(3),false,Priority.MEDIUM),
                new Task("Task3",null,null,false,Priority.MEDIUM),
                new Task("Task4","Account Task",null,false,Priority.HIGH)
        );
    }

    @Positive
    @ParameterizedTest
    @MethodSource("createCorrectList")
    void testAddTask(Task task){
        taskList.addTask(task);
        assertTrue(taskList.getTaskList().contains(task), "Correct tasks not added");
    }


    private static List<Task> createIncorrectList(){
        return List.of(
                new Task("Task1","Transaction Task",LocalDate.now().plusDays(2),false, null),
                new Task(null,"Notification Task", LocalDate.now().minusDays(3),false,Priority.MEDIUM),
                new Task(null,"Notification Task", LocalDate.now().minusDays(3),false,null)
        );
    }

    @Negative
    @ParameterizedTest
    @MethodSource("createIncorrectList")
    void testNotAddTask(Task task){
        taskList.addTask(task);
        assertTrue(taskList.getTaskList().isEmpty(), "Incorrect tasks not added");
    }

}
