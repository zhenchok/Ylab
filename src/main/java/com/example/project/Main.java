package com.example.project;

import com.example.project.model.Role;
import com.example.project.service.UserManagement;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать!");

        /*// Запросить у пользователя имя пользователя и пароль
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        // Проверить, является ли пользователь администратором
        if (isAdmin(username)) {
            System.out.println("Вы администратор.");

            // Администратор может редактировать имя и пароль
            System.out.print("Введите новое имя пользователя: ");
            String newUsername = scanner.nextLine();
            System.out.print("Введите новый пароль: ");
            String newPassword = scanner.nextLine();

            // Регистрация нового пользователя с новыми данными
            userManagement.registerUser(newUsername, newPassword, Role.USER);
            System.out.println("Пользователь успешно зарегистрирован.");
        } else {
            // Регистрация нового пользователя
            userManagement.registerUser(username, password, Role.USER);
            System.out.println("Пользователь успешно зарегистрирован.");
        }*/

        // Запросить у пользователя имя пользователя и пароль
        String username = "";
        String password = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите имя пользователя: ");
            username = scanner.nextLine().trim();
            System.out.print("Введите пароль: ");
            password = scanner.nextLine().trim();

            // Проверка на пустой ввод
            if (username.isEmpty() || password.isEmpty()) {
                System.out.println("Имя пользователя и пароль не могут быть пустыми. Попробуйте снова.");
            } else {
                validInput = true;
            }
        }

        // Проверить, является ли пользователь администратором
        if (isAdmin(username)) {
            System.out.println("Вы администратор.");

            // Администратор может редактировать имя и пароль
            System.out.print("Введите новое имя пользователя: ");
            String newUsername = scanner.nextLine().trim();
            System.out.print("Введите новый пароль: ");
            String newPassword = scanner.nextLine().trim();

            // Регистрация нового пользователя с новыми данными
            userManagement.registerUser(newUsername, newPassword, Role.USER);
            System.out.println("Пользователь успешно зарегистрирован.");
        } else {
            // Регистрация нового пользователя
            userManagement.registerUser(username, password, Role.USER);
            System.out.println("Пользователь успешно зарегистрирован.");
        }

        scanner.close();
    }

    // Метод для проверки, является ли пользователь администратором
    private static boolean isAdmin(String username) {
        // Здесь можно задать список администраторов
        String[] adminUsernames = {"zhenchok"}; // Пример списка администраторов

        // Проверяем, есть ли имя пользователя в списке администраторов
        for (String adminUsername : adminUsernames) {
            if (username.equals(adminUsername)) {
                return true;
            }
        }

        return false;
    }
}

/*public class Main {
    public static void main(String[] args) {
        // Создание экземпляра сервиса управления пользователями
        UserManagement userManager = new UserManagement();

        // Регистрация нового пользователя
        userManager.registerUser("user1", "password1", Role.USER);

        // Аутентификация пользователя
        User authenticatedUser = userManager.authenticateUser("user1", "password1");
        if (authenticatedUser != null) {
            System.out.println("Пользователь успешно аутентифицирован: " + authenticatedUser.getUsername());
        } else {
            System.out.println("Неверные данные аутентификации");
        }

        // Удаление пользователя
        boolean userDeleted = userManager.deleteUser("user1");
        if (userDeleted) {
            System.out.println("Пользователь успешно удален");
        } else {
            System.out.println("Ошибка при удалении пользователя");
        }
    }
}*/