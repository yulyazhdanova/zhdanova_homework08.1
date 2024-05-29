package tags;

import org.example.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RenameTaskListTest {

    private TaskList taskList;

    @BeforeEach
    void setUp(){
        taskList = new TaskList("Список задач №1");
    }

    @Test
    void testListRename(){
        final String expectedName = "Список задач №1";
        taskList.setName(expectedName);
        Assertions.assertEquals(expectedName,taskList.getName(),"Неверное имя списка после переименования");
    }


}
