package com.example.inlamningsuppgift_g_tdd.service;

import com.example.inlamningsuppgift_g_tdd.entities.AppUser;

public class AuthService {

    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }



    public boolean authenticate(String username, String password) throws IllegalArgumentException{


            AppUser appUser = userService.findUserByUsername(username);


           if(appUser == null) {

            throw new IllegalArgumentException("No user with that username exists in the db");
           }

            if (!appUser.getPassword().equals(password)) {

                throw new IllegalArgumentException("Wrong Password");
            }

    return true;
        }


    }
