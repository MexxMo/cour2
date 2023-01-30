
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;

import task.*;
import exception.*;
import service.TaskService;

public class Main {
    public static TaskService taskService = new TaskService();
    private static final Pattern DATE_TIME_PATTERN = Pattern.compile("\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}");
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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
                            printTaskByDay(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        } catch (IncorrectArgumentException e) {
             System.out.println(e.getMessage());
        }
    }

    private static void inputTask(Scanner scanner) throws IncorrectArgumentException {
        scanner.useDelimiter("\n");

        System.out.print("Введите название задачи: ");
        String title = scanner.next();

        System.out.print("Введите описание задачи: ");
        String description = scanner.next();

        System.out.print("Введите тип задачи 1- личная, 2- рабочая: ");
        Type type = null;

        int typeChoice = scanner.nextInt();

        if (typeChoice == 1) {
            type = Type.PERSONAL;
        } else if (typeChoice == 2) {
            type = Type.WORK;
        } else {
            System.out.println("Ошибка--> Выберите тип задачи: ");
            scanner.close();
        }

        System.out.print("Введите дату и время в формате dd-MM-yyyy HH:mm ");
        LocalDateTime taskTime = null;
        if (scanner.hasNext(DATE_TIME_PATTERN)) {
            String dateTime = scanner.next(DATE_TIME_PATTERN);
            taskTime = LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
        } else {
            System.out.print("Введите дату и время в формате dd-MM-yyyy HH:mm ");
            scanner.close();
        }


        System.out.print("Введите повторяемость задачи: 1- однократно, 2- каждый день, 3- каждую неделю, 4- каждый месяц, 5- каждый год: ");
        Task task = null;

        if (scanner.hasNextInt()) {

            int repeatability = scanner.nextInt();

            switch (repeatability) {
                case 1:
                    task = new OneTimeTask(title, description, type, taskTime);
                    break;
                case 2:
                    task = new DailyTask(title, type, description, taskTime);
                    break;
                case 3:
                    task = new WeeklyTask(title, description, type, taskTime);
                    break;
                case 4:
                    task = new MonthlyTask(title, description, type, taskTime);
                    break;
                case 5:
                    task = new YearlyTask(title, description, type, taskTime);
                    break;
            }
        }
        taskService.add(task);
        System.out.println("Задача создана");

    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Введите id для удаления: ");
        int id = scanner.nextInt();

        try {
            taskService.remove(id);
            System.out.println("Задача " + id + " успешно удалена!");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printTaskByDay(Scanner scanner) {

        System.out.print("Введите дату  dd-MM-yyyy для получения задачи: ");

        if (scanner.hasNext(DATE_PATTERN)) {
            String dateTime = scanner.next(DATE_PATTERN);
            LocalDate inputDate = LocalDate.parse(dateTime, DATE_FORMATTER);
            Collection<Task> tasksByDay = taskService.getAllByDate(inputDate);

            for (Task task : tasksByDay) {
                System.out.println(task);
            }

        } else {
            System.out.print("Введите дату в формате dd-MM-yyyy ");
            scanner.close();
        }
    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n0. Выход");
    }
}