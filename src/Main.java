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
                    list.addTask(taskToAdd, TaskStatus.IN_PROCESS);
                    break;
                case 3:
                    System.out.print("enter task to find: ");
                    scan.nextLine(); // Очищаем символ новой строки из буфера
                    String taskToFind = scan.nextLine();
                    list.searchTask(taskToFind);
                    break;
                case 4:
                    System.out.print("enter task to remove (its number): ");
                    scan.nextLine();
                    int removeIndex = scan.nextInt();
                    list.removeTask(removeIndex);
                    break;
                case 5:
                    System.out.println("enter the number of task: ");
                    int index = scan.nextInt();
                    modifyMenu();
                    scan.nextLine();
                    int answer = scan.nextInt();
                    scan.nextLine();
                    if (answer == 1) {
                        System.out.println("write here new text: ");
                        list.modifyText(index - 1, scan.nextLine());
                    }
                    else if (answer == 2)
                        list.modifyStatus(index - 1, TaskStatus.DONE);
                    else {
                        System.out.println("write here new text: ");
                        list.modifyBoth(index - 1, scan.nextLine(), TaskStatus.DONE);
                    }
                    break;
                case -1:
                    cycle = false;
                    break;
            }
        }
        scan.close();
    }

    public static void menu() {
        System.out.println("\n-ToDo-");
        System.out.println("1. print tasks.");
        System.out.println("2. add task.");
        System.out.println("3. find task.");
        System.out.println("4. remove task.");
        System.out.println("5. modify task.");
        System.out.println("-1. exit.");
        System.out.print("enter your choice: ");
        //add file input and output

    }
    public static void modifyMenu() {
        System.out.println("do you want to modify text(1) or status(2) or both(3)? ");
    }

}

