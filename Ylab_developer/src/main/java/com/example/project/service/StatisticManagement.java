package com.example.project.service;

import com.example.project.model.Training;

import java.util.List;

public class StatisticManagement {
    public int calculateCalories(List<Training> trainings) {
        if (trainings == null) {
            return 0;
        }
        int calories = 0;
        for (Training training : trainings) {
            calories += training.getCaloriesBurned();
        }
        return calories;
    }

    public double calculateAverageCaloriesPerTraining(List<Training> trainings) {
        if (trainings.isEmpty() || trainings == null) {
            return 0;
        }
        int totalCalories = calculateCalories(trainings);
        return (double) totalCalories / trainings.size();
    }

    public int calculateTotalDuration(List<Training> trainings) {
        if (trainings == null) {
            return 0;
        }
        int totalDuration = 0;
        for (Training training : trainings) {
            totalDuration += training.getDurationInMinutes();
        }
        return totalDuration;
    }
}
