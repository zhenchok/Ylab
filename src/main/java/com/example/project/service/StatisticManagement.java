package com.example.project.service;

import com.example.project.model.Training;

import java.util.List;
import java.util.Map;

public class StatisticManagement {
    public int calculateCalories(List<Training> trainings) {
        if (trainings == null) {
            return 0;
        }
        int calories = 0;
        for (Training training : trainings) {
            Map<String, Integer> exercises = training.getExercises();
            for (int burnedCalories : exercises.values()) {
                calories += burnedCalories;
            }
        }
        return calories;
    }


    public double calculateAverageCaloriesPerTraining(List<Training> trainings) {
        if (trainings == null || trainings.isEmpty()) {
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
            if (training != null) {
                totalDuration += training.getDurationInMinutes();
            }
        }
        return totalDuration;
    }
}
