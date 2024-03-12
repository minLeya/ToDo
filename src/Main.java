public class Main {
    public static void main(String[] args) {
        TaskList list = new TaskList();
        //list.printList();
        list.addTask("clean the room", false);
        //list.printList();
        list.addTask("go out", true);
        //list.printList();
        list.addTask("learn java", false);
        list.printList();
    }
}

