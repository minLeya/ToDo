import java.lang.String;
public class Task {
    private String textOfTask;
    private TaskStatus taskStatus;

    Task() { }

    Task(String textOfTask, TaskStatus taskStatus){
        this.textOfTask = textOfTask;
        this.taskStatus = taskStatus;
    }

    public void setTextOfTask(String textOfTask) {
        this.textOfTask = textOfTask;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTextOfTask() {
        return textOfTask;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public boolean searchTask(String textToSearch) {
        return (textOfTask.equals(textToSearch));
    }

    public void modifyTask(String newTask, TaskStatus newTaskStatus) {
        setTextOfTask(newTask);
        setTaskStatus(newTaskStatus);
    }

}

