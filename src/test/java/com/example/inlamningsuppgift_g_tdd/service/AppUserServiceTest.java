package com.example.inlamningsuppgift_g_tdd.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppUserServiceTest {

    @Mock
    UserRepo userRepo;
    private UserService userService;

    private static long id = 1;
    private final static String username = "Test";
    private final static String password = "test123";

    @BeforeEach
    public void init() {
        userService = new UserService(userRepo);
    }

    @Test
    public void findUserByUsername_withCorrectUsername_shouldReturnUser() {
        // Given
        AppUser appUser = new AppUser(id,username, password);

        // When
        when(userRepo.findUserByUsername(username)).thenReturn(Optional.of(appUser));
        AppUser returnedAppUser = userService.findUserByUsername(username);

        // Assert
        assertEquals(appUser, returnedAppUser);
        verify(userRepo, times(1)).findUserByUsername(username);

    }
}