import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks;
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    };


    public void addTask(String textOfTask, boolean isDone) {
        var newTask = new Task(textOfTask, isDone);
        tasks.add(newTask);
    }

    public void printList() {
        if (tasks.isEmpty()) {
            System.out.print("The list is empty!\n");
        }
        else {
            for(Task task : tasks) {
                System.out.print(task.getTextOfTask() + " ");
                if (task.getIsDone()) {
                    System.out.print("|         done!\n");
                }
                else {
                    System.out.print("|         in process!\n");
                }
            }
        }
    }

    public int findTask(String text) {
        return tasks.indexOf(text);
    }
    public void removeTask() {}


}