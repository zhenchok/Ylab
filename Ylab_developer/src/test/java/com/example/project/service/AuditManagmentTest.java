package com.example.project.service;

import com.example.project.model.Training;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AuditManagmentTest {

    @Test
    void testLogTrainingAddition() {
        AuditManagment auditManagment = new AuditManagment();
        Training training = new Training(new Date(), "Running", 30, 200, "Morning run");
        auditManagment.logTrainingAddition("testUser", training);
    }
}
