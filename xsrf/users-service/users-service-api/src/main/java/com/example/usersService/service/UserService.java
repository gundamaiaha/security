package com.example.usersService.service;

import com.example.usersService.model.User;

import java.util.List;

public interface UserService
{

    void createUser(final User user);
    User getUserDetails();
    User getUserDetails(final Long userId);
    List<User> getAllUsers();


}
