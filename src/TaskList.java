import java.util.ArrayList;

public class TaskList {

    private final ArrayList<Task> tasks;
    public TaskList() {
        this.tasks = new ArrayList<>();
    }


    public void addTask(String textOfTask, boolean isDone) {
        var newTask = new Task(textOfTask, isDone);
        tasks.add(newTask);
    }

    public void printList() {
        System.out.println();
        if (tasks.isEmpty()) {
            System.out.print("The list is empty!\n");
        }
        else {
            for(Task task : tasks) {
                System.out.print(task.getTextOfTask() + " ");
                if (task.getIsDone()) {
                    System.out.print("[done!]\n");
                }
                else {
                    System.out.print("[in process!]\n");
                }
            }
        }
        System.out.println();
    }

    public int findTask(String textToSearch) {
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).searchTask(textToSearch))
                return i;
        }
        return -1;
    }

    public void searchTask(String textToSearch) {
        int index = this.findTask(textToSearch);
        if(index == -1) {
            System.out.print("There's no such task!\n");
        }
        else {
            System.out.print("This task is found! It's under index " + index + "\n");
        }
    }

    public void removeTask(String taskToDelete) {
        int index = this.findTask(taskToDelete);
        if (index == -1)
            System.out.print("Cannot remove, there's no such task!\n");
        else
            tasks.remove(index);
    }

    //use numeration and print sorted list
}