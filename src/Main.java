import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TaskService taskService = new TaskService();
        taskService.add(new OneTimeTask("Прочитать почту", Type.WORK, "Бесполезная трата времени"));
        taskService.add(new WeeklyTask("Написать отчёт", Type.WORK, "отчёт по текущим задачам"));
        taskService.add(new MonthlyTask("Провести собрание", Type.WORK, "подвести итоги"));

        System.out.println(taskService.getAllGropeByDate());

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите номер нужной задачи: " + "\n" +
                    "1. Добавить задачу " + "\n" +
                    "2. Посмотреть задачи на день " + "\n" +
                    "3. Удалить задачу " + "\n" +
                    "0. Выход ");

            int number = scanner.nextInt();

            switch (number) {
                case (1):
                    final Task task = readAndCreateTask();
                    taskService.add(task);
                    break;
                case (2):
                    System.out.println(taskService.getAllByDate(LocalDate.now()));
                    break;
                case (3):
                    final Task removed = taskService.remove(readId());
                    System.out.println(removed);
                    break;
                case (0):
                    return;
                default:
                    System.out.println("Введено некоректное значение");
                    break;

            }
        }
    }

    public static Task readAndCreateTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название задачи: ");
        final String title = scanner.next();
        final Type type = readType();
        System.out.print("Введите описание задачи: ");
        final String description = scanner.next();
        System.out.println("Выберите периодичность: " + "\n" +
                "1. Однократная " + "\n" +
                "2. Ежедневная " + "\n" +
                "3. Еженедельная " + "\n" +
                "4. Ежемесячная" + "\n" +
                "5.Ежегодная");
        int periodic = scanner.nextInt();
        Task task = null;
        switch (periodic) {
            case (1):
                task = new OneTimeTask(title, type, description);
                break;
            case (2):
                task = new DailyTask(title, type, description);
                break;
            case (3):
                task = new WeeklyTask(title, type, description);
                break;
            case (4):
                task = new MonthlyTask(title, type, description);
                break;
            case (5):
                task = new YearlyTask(title, type, description);
                break;
            default:
                System.out.println("Введено некоректное значение");
                break;

        }
        return task;
    }

    public static int readId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id задачи: ");
        final int id = scanner.nextInt();
        return id;
    }

    public static Type readType() {
        HashMap<Integer, Type> typeMap = new HashMap<>();
        typeMap.put(1, Type.PERSONAL);
        typeMap.put(2, Type.WORK);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите тип задачи: " + "\n" +
                "1. Личная" + "\n" +
                "2. Рабочая" + "\n");
        final int type = scanner.nextInt();
        return typeMap.get(type);

    }
}