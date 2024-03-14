import java.util.ArrayList;

public class TaskList {

    private final ArrayList<Task> tasks;
    public TaskList() {
        this.tasks = new ArrayList<>();
    }


    public void addTask(String textOfTask, TaskStatus status) {
        var newTask = new Task(textOfTask, status);
        tasks.add(newTask);
    }

    public void printList() {
        System.out.println();
        if (tasks.isEmpty()) {
            System.out.print("The list is empty!");
        }
        else {
            for (int i = 0; i < tasks.size(); i++)
            {
                Task task = tasks.get(i);
                TaskStatus status = task.getTaskStatus();
                System.out.println((i + 1) +". " + task.getTextOfTask() + " [" + status.toString() + "]");
            }
        }
        System.out.print("\n");
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
            System.out.print("This task is found! It's under number " + (index + 1) + "\n");
        }
    }

    public void removeTask(int removeIndex) {
            tasks.remove(removeIndex - 1);
    }

    public void modifyText(int index, String newTask) {
        Task task = tasks.get(index);
        task.setTextOfTask(newTask);
    }

    public void modifyStatus(int index, TaskStatus newTaskStatus) {
        Task task = tasks.get(index);
        task.setTaskStatus(newTaskStatus);
    }

    public void modifyBoth(int index, String newTask, TaskStatus newTaskStatus) {
            Task task = tasks.get(index);
            task.modifyTask(newTask, newTaskStatus);
    }

    //use numeration+ and print sorted list
}