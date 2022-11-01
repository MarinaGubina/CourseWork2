import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static TaskService taskService = new TaskService();

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            removeTask(scanner);
                            break;
                        case 3:
                            getTask(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        scanner.nextLine();
        String taskName = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        scanner.nextLine();
        String description = scanner.nextLine();
        System.out.print("Выберите тип задачи, 1 - личная, 2 - рабочая: ");
        int t = scanner.nextInt();
        TypeOfTask type = null;
        if(t == 1){
            type = TypeOfTask.PERSONAl;
        }
        else if (t == 2) {
            type = TypeOfTask.WORK;
        }
        else {
            System.out.println("неверный формат");
        }
        Repeatable repeatable = null;
        System.out.print("Повторяемость задачи: O - однократная,D - ежедневная, W - еженедельная," +
                "M - ежемесячная, Y - ежегодная : ");
        String r = scanner.next();
        switch (r){
            case "O":
                repeatable = Repeatable.SINGLE_Task;
                break;

            case "D":
                repeatable= Repeatable.DAILY_Task;
                break;

            case "W":
                repeatable= Repeatable.WEEKLY_Task;
                break;

            case "M":
                repeatable = Repeatable.MONTHLY_Task;
                break;

            case "Y":
                repeatable = Repeatable.YEARLY_TASK;
                break;

            default:
                System.out.println("неверный формат");
        }
        System.out.print("Введите дату и время задачи в формате yyyy-MM-dd;HH:mm :");
        String dT = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd;HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dT,formatter);
        
        Task task = new Task(taskName,description,type,repeatable,dateTime);
        taskService.addTask(task);
        taskService.printTest();
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Введите id задачи, которую хотите удалить: ");
        int id  = scanner.nextInt();
        taskService.removeTask(id);
        taskService.printTest();
    }

    private static void getTask(Scanner scanner){
        System.out.print("Введите дату в формате yyyy-MM-dd :");
        String d = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(d,formatter);
        System.out.println(taskService.getTaskForDay(date));
    }

    private static void printMenu() {
        System.out.println(
                        "1. Добавить задачу \n" +
                        "2. Удалить задачу \n" +
                        "3. Получить задачу на указанный день \n" +
                        "0. Выход \n");
    }
}