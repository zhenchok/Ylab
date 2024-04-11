package com.example.project;
import com.example.project.model.Role;
import com.example.project.model.Training;
import com.example.project.service.TrainingManagement;
import com.example.project.service.UserManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        TrainingManagement trainingManagement = new TrainingManagement();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать!");

        // Регистрация пользователя
        String username = "";
        String password = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Введите имя пользователя: ");
            username = scanner.nextLine().trim();
            System.out.print("Введите пароль: ");
            password = scanner.nextLine().trim();

            if (username.isEmpty() || password.isEmpty()) {
                System.out.println("Имя пользователя и пароль не могут быть пустыми. Попробуйте снова.");
            } else {
                validInput = true;
            }
        }

        // Проверка на администратора и регистрация пользователя
        if (isAdmin(username)) {
            System.out.println("Вы администратор.");

            System.out.print("Введите новое имя пользователя: ");
            String newUsername = scanner.nextLine().trim();
            System.out.print("Введите новый пароль: ");
            String newPassword = scanner.nextLine().trim();

            userManagement.registerUser(newUsername, newPassword, Role.USER);
            System.out.println("Пользователь успешно зарегистрирован.");
        } else {
            userManagement.registerUser(username, password, Role.USER);
            System.out.println("Пользователь успешно зарегистрирован.");
        }

        // Добавление тренировки
        System.out.println("Хотите добавить новую тренировку? (yes/no)");
        String addTrainingChoice = scanner.nextLine().trim().toLowerCase();
        if (addTrainingChoice.equals("yes")) {
            System.out.println("Введите дату тренировки в формате ГГГГ-ММ-ДД: ");
            String dateString = scanner.nextLine().trim();
            System.out.println("Введите тип тренировки: ");
            String type = scanner.nextLine().trim();
            System.out.println("Введите продолжительность тренировки в минутах: ");
            int duration = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Введите количество сожженных калорий: ");
            int caloriesBurned = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Введите дополнительную информацию о тренировке: ");
            String additionalInfo = scanner.nextLine().trim();

            Date date = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("Вы ввели дату: " + date);
            Training training = new Training(date, type, duration, caloriesBurned, additionalInfo);
            trainingManagement.addTraining(username, training);
            System.out.println("Тренировка успешно добавлена.");
        }

        scanner.close();
    }

    private static boolean isAdmin(String username) {
        // Здесь можно задать список администраторов
        String[] adminUsernames = {"admin"};
        for (String adminUsername : adminUsernames) {
            if (username.equals(adminUsername)) {
                return true;
            }
        }
        return false;
    }
}

/*import com.example.project.model.Role;
import com.example.project.service.UserManagement;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать!");

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
*/