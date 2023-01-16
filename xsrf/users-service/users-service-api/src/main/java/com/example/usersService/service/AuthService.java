package com.example.usersService.service;

import com.example.usersService.model.User;

public interface AuthService
{


    void registerUser(final User user);

    void forgotPassword(final User user);

    void resetPassword(final String passwordResetToken);


}
