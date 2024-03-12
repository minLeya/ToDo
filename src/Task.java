import java.lang.String;
public class Task {
    private String textOfTask;
    private boolean isDone;

    Task() {

    }

    Task(String textOfTask, boolean isDone){
        this.textOfTask = textOfTask;
        this.isDone = isDone;
    }

    public void setTextOfTask(String textOfTask) {
        this.textOfTask = textOfTask;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getTextOfTask() {
        return textOfTask;
    }

    public boolean getIsDone() {
        return isDone;
    }
}
