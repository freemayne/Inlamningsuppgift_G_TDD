package com.example.inlamningsuppgift_g_tdd.auth;

import com.example.inlamningsuppgift_g_tdd.entities.AppUser;
import com.example.inlamningsuppgift_g_tdd.repo.UserRepo;
import com.example.inlamningsuppgift_g_tdd.service.AuthService;

import com.example.inlamningsuppgift_g_tdd.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class AuthenticationTest {

    @Mock
    private UserService userService;


    private AuthService authService;

    private final static long id = 1;
    private final static String username = "test";
    private final static String password = "test123";

@BeforeEach
public void onInit(){
    authService = new AuthService(userService);
}

    @Test
    public void testLogin_ifWorking_returnTrue()  {
        //Given
        AppUser appUser = new AppUser(id, username, password);
        when(userService.findUserByUsername("test")).thenReturn(appUser);

        boolean result = authService.authenticate("test", "test123");

        //When, then
        assertTrue(result);

    }
   @Test
    public void login_throwErrorIfWrongUsername() {

       //Given
       AppUser appUser = new AppUser(id,username, password);
       lenient().when(userService.findUserByUsername("test")).thenReturn(appUser);

       //When
       IllegalArgumentException err = assertThrows(IllegalArgumentException.class, () -> authService.authenticate("tester", "test123"));
       //then
       assertEquals("No user with that username exists in the ",err.getMessage());
    }

    @Test
    public void login_throwErrorIfWrongPassword() {

        //Given
        AppUser appUser = new AppUser(id,username, password);
        when(userService.findUserByUsername("test")).thenReturn(appUser);

        //when
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class, () -> authService.authenticate("test", "test1232"));
        // then
        assertEquals("Wrong Passwor",err.getMessage());

    }




}