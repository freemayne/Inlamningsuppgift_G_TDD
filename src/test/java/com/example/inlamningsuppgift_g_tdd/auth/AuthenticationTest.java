package com.example.inlamningsuppgift_g_tdd.auth;

import com.example.inlamningsuppgift_g_tdd.entities.AppUser;
import com.example.inlamningsuppgift_g_tdd.repo.UserRepo;
import com.example.inlamningsuppgift_g_tdd.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class AuthenticationTest {

    @Mock
    private UserRepo userRepo;

    private UserService userService;

    private final static long id = 1;
    private final static String username = "test";
    private final static String password = "test123";

    @BeforeEach
    public void init(){
        userService = new UserService(userRepo);
    }

    @Test
    public void testLogin_ifWorking_returnTrue()  {
        //Given
        AppUser appUser = new AppUser(id, username, password);
        when(userRepo.findUserByUsername("test")).thenReturn(Optional.of(appUser));

        boolean result = userService.authenticate("test", "test123");

        //When, then
        assertTrue(result);

    }
    @ParameterizedTest
    @CsvSource(value = {"test,test1234","testare,test123"})
    public void login_throwErrorIfWrongUsernameOrPassword(String testUsername, String testPassword) {

        //Given
        AppUser appUser = new AppUser(id,username, password);
        when(userRepo.findUserByUsername(appUser.getUsername())).thenReturn(Optional.of(appUser));

        //When, then
        assertThrows(IllegalArgumentException.class, () -> userService.authenticate(testUsername, testPassword));

    }




}