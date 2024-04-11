/*package com.example.project.service;

import main.java.com.example.project.model.User;
import main.java.com.example.project.service.UserManagement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagementTest {
    @Test
    public void testRegisterUser() {
        UserManagement userManagement = new UserManagement();
        assertTrue(userManagement.registerUser("testUser", "password"));
    }

    @Test
    public void testAuthenticateUser() {
        UserManagement userManager = new UserManagement();
        userManager.registerUser("testUser", "password");
        assertNotNull(userManager.authenticateUser("testUser", "password"));
    }

    @Test
    public void testAuthenticateUserInvalidCredentials() {
        UserManagement userManagement = new UserManagement();
        userManagement.registerUser("testUser", "password");
        assertNull(userManagement.authenticateUser("testUser", "wrongPassword"));
    }
}
*/