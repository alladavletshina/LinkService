package org.example;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private final Scanner scanner;
    private final UrlShortMaker urlShortMaker;

    public Main() {
        scanner = new Scanner(System.in);
        urlShortMaker = new UrlShortMaker();
    }

    public void startApplication() {
        while (true) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.println("Введите длинный URL для преобразования в короткую ссылку");
                    //String longId = scanner.nextLine();
                    String longId = "https://www.baeldung.com/java-9-http-clients";
                    System.out.println(longId);
                    //String shortUrl = urlShortMaker.linkShortMaker(longId);
                    String shortUrl = urlShortMaker.generateUniqueUrl(longId);
                    System.out.println("Короткая ссылка: " + shortUrl);
                    break;
                case 2:
                    System.out.println("КОД-2");
                    break;
                case 3:
                    System.out.println("КОД-3");
                    break;
                case 0:
                    exitApp();
                    return;
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
        System.out.println("2. Посмотреть список своих ссылок");
        System.out.println("3. Удалить свою ссылку");
        System.out.println("0. Выход");
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

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Добро пожаловать в сервис сокращения ссылок!");
        main.startApplication();
        }
}
