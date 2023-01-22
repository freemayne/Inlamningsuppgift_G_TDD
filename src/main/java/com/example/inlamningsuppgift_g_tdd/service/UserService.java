package com.example.inlamningsuppgift_g_tdd.service;


import com.example.inlamningsuppgift_g_tdd.entities.AppUser;
import com.example.inlamningsuppgift_g_tdd.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public AppUser findUserByUsername(String username) {
        return userRepo.findUserByUsername(username).orElseThrow();
    }

    public boolean authenticate(String username, String password) {
        AppUser appUser = userRepo.findUserByUsername(username).orElseThrow();
        if(appUser.getUsername() != null && appUser.getPassword().equals(password)){
            return true;
        }

        return false;
    }
}