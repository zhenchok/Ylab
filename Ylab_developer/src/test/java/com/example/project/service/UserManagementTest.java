package com.example.project.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.example.project.model.Role;
import com.example.project.model.User;
import com.example.project.service.UserManagement;

public class UserManagementTest {

    @Test
    void testRegisterUser() {
        UserManagement userManager = new UserManagement();
        assertTrue(userManager.registerUser("testUser", "password", Role.USER));
    }

    @Test
    void testAuthenticateUser() {
        UserManagement userManager = new UserManagement();
        userManager.registerUser("testUser", "password", Role.USER);
        assertNotNull(userManager.authenticateUser("testUser", "password"));
    }

    @Test
    void testDeleteUser() {
        UserManagement userManager = new UserManagement();
        userManager.registerUser("testUser", "password", Role.USER);
        assertTrue(userManager.deleteUser("testUser"));
    }
}
