package com.example.demo.auth.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.auth.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}