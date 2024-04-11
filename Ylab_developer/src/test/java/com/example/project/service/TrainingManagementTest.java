package com.example.project.service;

import com.example.project.model.Training;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainingManagementTest {

    private TrainingManagement trainingManager;

    @BeforeEach
    void setUp() {
        trainingManager = new TrainingManagement();
    }

    @Test
    void testAddTraining() {
        Training training = new Training(new Date(), "Running", 30, 200, "Morning run");
        assertTrue(trainingManager.addTraining("testUser", training));
    }

    @Test
    void testEditTraining() {
        Training training = new Training(new Date(), "Running", 30, 200, "Morning run");
        trainingManager.addTraining("testUser", training);
        assertTrue(trainingManager.editTraining("testUser", 0, training));
    }

    @Test
    void testDeleteTraining() {
        Training training = new Training(new Date(), "Running", 30, 200, "Morning run");
        trainingManager.addTraining("testUser", training);
        assertTrue(trainingManager.deleteTraining("testUser", 0));
    }

    @Test
    void testEditTrainingWithInvalidIndex() {
        Training training = new Training(new Date(), "Running", 30, 200, "Morning run");
        trainingManager.addTraining("testUser", training);
        assertFalse(trainingManager.editTraining("testUser", 1, training));
    }

    @Test
    void testDeleteTrainingWithInvalidIndex() {
        Training training = new Training(new Date(), "Running", 30, 200, "Morning run");
        trainingManager.addTraining("testUser", training);
        assertFalse(trainingManager.deleteTraining("testUser", 1));
    }

    @Test
    void testEditTrainingWithNonExistingUser() {
        Training training = new Training(new Date(), "Running", 30, 200, "Morning run");
        assertFalse(trainingManager.editTraining("nonExistingUser", 0, training));
    }

    @Test
    void testDeleteTrainingWithNonExistingUser() {
        assertFalse(trainingManager.deleteTraining("nonExistingUser", 0));
    }
}
