import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class TaskTest {

  @Test
  public void newTask_instanttiatesCorrectly() {
    Task testTask = new Task("test");
    assertEquals(true, testTask instanceof Task);
  }

  @Test
  public void newTask_returnsDescription_Test() {
    Task testTask = new Task("test");
    assertEquals("test", testTask.getDescription());
  }

  @Test
  public void isCompleteed_isFalseAfterInstantiation_false() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(false, myTask.isCompleted());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myTask.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOfTask_true() {
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("Buy Groceries");
    assertEquals(true, Task.all().contains(firstTask));
    assertEquals(true, Task.all().contains(secondTask));
  }

  @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    Task myTask = new Task("Mow the lawn");
    Task.clear();
    assertEquals(Task.all().size(), 0);
  }

  @Test
  public void getId_tasksInstantiateWithAnID_1() {
    Task.clear();
    Task myTask = new Task("Mow the lawn");
    assertEquals(1, myTask.getId());
  }

  @Test
  public void find_returnTaskWithSameId_secondTask() {
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("buy groceries");
    assertEquals(Task.find(secondTask.getId()), secondTask);
  }
}
