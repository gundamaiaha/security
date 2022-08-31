package com.example.userservice;

import com.example.userservice.model.User;

public interface AuthService {

    void  registerUser(final User user);

    // add auth related methods like forgotPassword, changeRole ....
}
