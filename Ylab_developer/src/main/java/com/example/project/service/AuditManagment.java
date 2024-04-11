package com.example.project.service;

import com.example.project.model.Training;

import java.util.Date;

public class AuditManagment {
    public void logRegistration(String username) {
        System.out.println("[" + new Date() + "] Пользователь " + username + " зарегистрирован");
    }

    public void logAuthentication(String username) {
        System.out.println("[" + new Date() + "] Пользователь " + username + " аутентифицирован");
    }

    public void logTrainingAddition(String username, Training training) {
        System.out.println("[" + new Date() + "] Пользователь " + username + " добавил тренировку: " + training);
    }

    public void logTrainingEdit(String username, Training oldTraining, Training newTraining) {
        System.out.println("[" + new Date() + "] Пользователь " + username + " изменил тренировку: " + oldTraining + " на " + newTraining);
    }

    public void logTrainingDeletion(String username, Training training) {
        System.out.println("[" + new Date() + "] Пользователь " + username + " удалил тренировку: " + training);
    }

    public void logStatisticsRequest(String username) {
        System.out.println("[" + new Date() + "] Пользователь " + username + " запросил статистику тренировок");
    }
}
