package com.example.project.service;

import com.example.project.model.Role;
import com.example.project.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserManagement {
    private Map<String, User> users;

    public UserManagement() {
        this.users = new HashMap<>();
    }

    public boolean registerUser(String username, String password, Role role) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return false; // Нельзя зарегистрировать пользователя с пустым именем или паролем
        }
        if (role == null) {
            return false; // Нельзя зарегистрировать пользователя с нулевой ролью
        }
        if (users.containsKey(username)) {
            return false; // Пользователь с таким Ником уже зарегистрирован
        }

        User newUser = new User(username, password, role); // Создаем нового пользователя
        users.put(username, newUser); // Добавляем пользователя в список зарегистрированных
        return true; // Регистрация успешна
    }

    public User authenticateUser(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return null; // Неверные данные аутентификации
        }

        User user = users.get(username); // Получаем пользователя по имени пользователя
        if (user != null && user.getPassword().equals(password)) {
            return user; // Аутентификация успешна
        } else {
            return null; // Неверные данные аутентификации
        }
    }

    // Метод для удаления пользователя
    public boolean deleteUser(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }

        if (users.containsKey(username)) {
            users.remove(username);
            return true;
        } else {
            return false;
        }
    }

    // Метод для получения списка всех зарегистрированных пользователей
    public Map<String, User> getAllUsers() {
        return new HashMap<>(users);
    }

    // Метод для редактирования пользователя
    public boolean editUser(String username, String newPassword, Role newRole) {
        if (username == null || username.isEmpty() || newPassword == null || newPassword.isEmpty() || newRole == null) {
            return false;
        }

        User user = users.get(username);
        if (user != null) {
            // Устанавливаем новый пароль и роль
            user.setPassword(newPassword);
            user.setRole(newRole);
            return true;
        } else {
            return false;
        }
    }
}
