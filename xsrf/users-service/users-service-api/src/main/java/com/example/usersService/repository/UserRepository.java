package com.example.usersService.repository;

import com.example.usersService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    boolean existsByUsername(String username);
}
