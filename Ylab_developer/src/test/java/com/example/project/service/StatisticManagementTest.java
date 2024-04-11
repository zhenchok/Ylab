package com.example.project.service;

import com.example.project.model.Training;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticManagementTest {

    @Test
    void testCalculateCalories() {
        StatisticManagement statisticManagement = new StatisticManagement();
        List<Training> trainings = new ArrayList<>();
        Training training = new Training(new Date(), "Running", 30, 200, "Morning run");
        trainings.add(training);
        assertEquals(200, statisticManagement.calculateCalories(trainings));
    }

    @Test
    void testCalculateAverageCaloriesPerTraining() {
        StatisticManagement statisticManagement = new StatisticManagement();
        List<Training> trainings = new ArrayList<>();
        Training training1 = new Training(new Date(), "Running", 30, 200, "Morning run");
        Training training2 = new Training(new Date(), "Cycling", 45, 300, "Afternoon ride");
        trainings.add(training1);
        trainings.add(training2);
        assertEquals(250.0, statisticManagement.calculateAverageCaloriesPerTraining(trainings));
    }

    @Test
    void testCalculateTotalDuration() {
        StatisticManagement statisticManagement = new StatisticManagement();
        List<Training> trainings = new ArrayList<>();
        Training training1 = new Training(new Date(), "Running", 30, 200, "Morning run");
        Training training2 = new Training(new Date(), "Cycling", 45, 300, "Afternoon ride");
        trainings.add(training1);
        trainings.add(training2);
        assertEquals(75, statisticManagement.calculateTotalDuration(trainings));
    }
}
