import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskList list = new TaskList();
        Scanner scan = new Scanner(System.in);
        boolean cycle = true;
        while (cycle) {
            menu();
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    list.printList();
                    break;
                case 2:
                    System.out.print("enter task to add: ");
                    scan.nextLine(); // Очищаем символ новой строки из буфера
                    String taskToAdd = scan.nextLine();
                    System.out.print("enter is it in process (false) or done (true): ");
                    boolean isDone = scan.nextBoolean();
                    scan.nextLine(); // Очистка символа новой строки из буфера
                    list.addTask(taskToAdd, isDone);
                    break;
                case 3:
                    System.out.print("enter task to find: ");
                    scan.nextLine(); // Очищаем символ новой строки из буфера
                    String taskToFind = scan.nextLine();
                    list.searchTask(taskToFind);
                    break;
                case 4:
                    System.out.print("enter task to remove: ");
                    scan.nextLine();
                    String taskToRemove = scan.nextLine();
                    list.removeTask(taskToRemove);
                    break;
                case -1:
                    cycle = false;
                    break;
            }
        }
        scan.close();
    }

    public static void menu() {
        System.out.println("-ToDo-");
        System.out.println("1. print tasks.");
        System.out.println("2. add task.");
        System.out.println("3. find task.");
        System.out.println("4. remove task.");
        System.out.println("-1. exit.");
        System.out.print("enter your choice: ");
        //add file input and output

    }

}

