package com.example.inlamningsuppgift_g_tdd.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    public AppUser(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public AppUser(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser appUser)) return false;
        return Objects.equals(getId(), appUser.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}