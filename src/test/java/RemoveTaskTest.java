import org.example.Priority;
import org.example.Task;
import org.example.TaskList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tags.Positive;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveTaskTest {

    private TaskList taskList;
    private Task task1;
    private Task task2;

    @BeforeEach
    @Test
    void setUp(){
        task1 = new Task("Задача1", "Описание задачи 1", LocalDate.now(),false, Priority.LOW);
        task2 = new Task("Задача2", "Описание задачи 2", LocalDate.now(),false, Priority.MEDIUM);
        taskList = new TaskList("Список задач", List.of(task1,task2));
    }

    @Positive
    @Test
    void testRemoveTaskByName(){
        taskList.removeTaskByName(task1.getName());
        assertFalse(taskList.getTaskList().contains(task1), "Task was not removed");
    }


    @Positive
    @Test
    void testNotRemoveByName(){
        List<Task> expectedTasks = taskList.getTaskList();
        final String taskRemoved = "Task #100";
        taskList.removeTaskByName(taskRemoved);
        List<Task> factTask = taskList.getTaskList();
        assertEquals(expectedTasks,factTask,"Incorrect task was removed");
    }

    @Positive
    @Test
    void remoteComplitedTask(){
        task1.setCompleted(true);
        taskList.removeCompletedTask();
        assertFalse(taskList.getTaskList().contains(task1),"Completed task was not remote");
    }

    @Test
    void remoteAllTasks(){
        taskList.removeAllTask();
        assertTrue(taskList.getTaskList().isEmpty(), "Not empty tasl list after deleting all tasks");
    }

}
