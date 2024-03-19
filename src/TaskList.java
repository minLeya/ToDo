import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class TaskList {

    private final ArrayList<Task> list;
    public TaskList() {
        this.list = new ArrayList<>();
    }


    public void addTask(String textOfTask, TaskStatus status) {
        var newTask = new Task(textOfTask, status);
        list.add(newTask);
    }

    public void printList() {
        System.out.println();
        if (list.isEmpty()) {
            System.out.print("The list is empty!");
        }
        else {
            for (int i = 0; i < list.size(); i++)
            {
                Task task = list.get(i);
                TaskStatus status = task.getTaskStatus();
                System.out.println((i + 1) +". " + task.getTextOfTask() + " [" + status.toString() + "]");
            }
        }
        System.out.print("\n");
    }

    public int findTask(String textToSearch) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).searchTask(textToSearch))
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
            list.remove(removeIndex - 1);
    }

    public void modifyText(int index, String newTask) {
        Task task = list.get(index);
        task.setTextOfTask(newTask);
    }

    public void modifyStatus(int index, TaskStatus newTaskStatus) {
        Task task = list.get(index);
        task.setTaskStatus(newTaskStatus);
    }

    public void modifyBoth(int index, String newTask, TaskStatus newTaskStatus) {
            Task task = list.get(index);
            task.modifyTask(newTask, newTaskStatus);
    }

    public void writeToFile() {
        try (FileWriter writer = new FileWriter("output.txt")) {
            if (list.isEmpty()) {
                writer.write("The list is empty!");
            } else {
                for (int i = 0; i < list.size(); i++) {
                    Task task = list.get(i);
                    TaskStatus status = task.getTaskStatus();
                    writer.write((i + 1) + ". " + task.getTextOfTask() + " [" + status.toString() + "]\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        String filepath ="C:\\Users\\Лейсан\\IdeaProjects\\ToDo\\src\\input.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\[");
                String taskText = parts[0].trim();
                String statusString = parts[1].substring(0, parts[1].indexOf("]")).trim();
                TaskStatus status = TaskStatus.valueOf(statusString);
                addTask(taskText, status);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}