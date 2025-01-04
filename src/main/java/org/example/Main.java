package org.example;
import java.util.Scanner;

public class Main {

    private final Scanner scanner;
    private String userId;

    public Main() {
        scanner = new Scanner(System.in);
    }

    private void startApplication(String userId) {
        while (true) {
            showMenu();
            int choice = getUserChoice();
            UrlShortMaker urlShortMaker = new UrlShortMaker();
            String shortUrl;
            this.userId = userId;

            switch (choice) {
                case 1:
                    System.out.println("Введите длинный URL для преобразования в короткую ссылку");
                    String longUrl = "https://www.baeldung.com/java-9-http-clients";
                    System.out.println(longUrl);

                    System.out.println("Установите лимит на количество переходов по ссылке");
                    int maxClicks = getUserChoice();

                    shortUrl = urlShortMaker.genеrateShortUrl(userId,maxClicks, longUrl);
                    System.out.println("Короткая ссылка: " + shortUrl);
                    urlShortMaker.printHistory();
                    break;
                case 2:
                    System.out.println("Введите короткую ссылку: ");
                    shortUrl = scanner.nextLine();
                    userId = scanner.nextLine();
                    System.out.println(urlShortMaker.getLongUrl(userId, shortUrl));
                    urlShortMaker.printHistory();
                    break;
                case 3:
                    System.out.println("КОД-3");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неправильный выбор. Попробуйте снова.");
            }
        }
    }

    private void exitApp() {
        System.out.println("\nДо свидание! Будем рады видеть Вас снова!");
        scanner.close();
        System.exit(0);
    }

    private void showMenu() {
        System.out.println("\nВыберите нужное действие:");
        System.out.println("1. Создать новую короткую ссылку");
        System.out.println("2. Перейти по короткой ссылке");
        System.out.println("3. Удалить свою ссылку");
        System.out.println("0. Вернуться в главное меню");
        System.out.print("Ваш выбор: ");
    }

    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Пожалуйста, введите число.");
            return -1;
        }
    }

    private void greetingShowMenu() {
        System.out.println("\nГлавное меню:");
        System.out.println("1. У меня есть уникальный идентификационный номер");
        System.out.println("2. Нет уникального идентификационного номера");
        System.out.println("0. Выход из приложения");
        System.out.print("Ваш выбор: ");
    }

    private void greetingApplication() {
        Main main = new Main();
        while (true) {
            greetingShowMenu();
            int choice = getUserChoice();
            String userId;

            switch (choice) {
                case 1:
                    System.out.println("Введите уникальный идентификационный номер:");
                    userId = scanner.nextLine();
                    startApplication(userId);
                    break;
                case 2:
                    User user = new User();
                    userId = user.getUuid();
                    System.out.println(userId);
                    startApplication(userId);
                    break;
                case 0:
                    exitApp();
                    return;
                default:
                    System.out.println("Неправильный выбор. Попробуйте снова.");
            }
        }
    }



    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Добро пожаловать в сервис сокращения ссылок!");
        main.greetingApplication();
        }
}
