package com.example.inlamningsuppgift_g_tdd.auth;

import com.example.inlamningsuppgift_g_tdd.entities.AppUser;
import com.example.inlamningsuppgift_g_tdd.repo.UserRepo;
import com.example.inlamningsuppgift_g_tdd.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;



@RunWith(MockitoJUnitRunner.class)
public class AuthenticationTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    private final static long id = 1;
    private final static String username = "test";
    private final static String password = "test123";

    @Test
    public void testLogin_ifWorking_returnTrue()  {
        //Given
        AppUser appUser = new AppUser(id, username, password);
        when(userRepo.findUserByUsername("test")).thenReturn(Optional.of(appUser));

        //When, then
        assertTrue(userService.authenticate("test", "test123"));

    }


}