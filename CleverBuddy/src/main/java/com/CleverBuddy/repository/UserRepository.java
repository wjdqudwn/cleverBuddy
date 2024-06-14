package com.CleverBuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cleverbuddy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
