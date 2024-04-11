package com.example.project.service;

import com.example.project.model.Training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingManagement {
    private Map<String, List<Training>> userTrainings;

    public TrainingManagement() {
        this.userTrainings = new HashMap<>();
    }

    public boolean addTraining(String username, Training training) {
        if (username == null || training == null) {
            return false;
        }
        userTrainings.putIfAbsent(username, new ArrayList<>());
        return userTrainings.get(username).add(training);
    }

    public List<Training> getUserTrainings(String username) {
        return userTrainings.getOrDefault(username, new ArrayList<>());
    }

    public boolean editTraining(String username, int trainingIndex, Training editedTraining) {
        List<Training> trainings = userTrainings.get(username);
        if (username == null || trainings == null || trainingIndex < 0 || trainingIndex >= trainings.size()) {
            return false;
        }
        trainings.set(trainingIndex, editedTraining);
        return true;
    }

    public boolean deleteTraining(String username, int trainingIndex) {
        List<Training> trainings = userTrainings.get(username);
        if (username == null || trainings == null || trainingIndex < 0 || trainingIndex >= trainings.size()) {
            return false;
        }
        trainings.remove(trainingIndex);
        return true;
    }
}
