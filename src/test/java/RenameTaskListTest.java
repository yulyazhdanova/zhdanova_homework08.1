import org.example.TaskList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tags.Positive;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RenameTaskListTest {

    private TaskList taskList;

    @BeforeEach
    void setUp(){
        taskList = new TaskList("Новый список задач");
    }

    @Positive
    @Test
    void testListRename(){
        final String expectedName = "Список задач №1";
        taskList.setName(expectedName);
        assertEquals(expectedName,taskList.getName(),"Неверное имя списка после переименования");
    }
}
