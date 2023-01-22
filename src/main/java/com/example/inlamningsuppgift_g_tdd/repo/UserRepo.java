package com.example.inlamningsuppgift_g_tdd.repo;



import com.example.inlamningsuppgift_g_tdd.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<AppUser, String> {
    Optional<AppUser> findUserByUsername(String username);
}