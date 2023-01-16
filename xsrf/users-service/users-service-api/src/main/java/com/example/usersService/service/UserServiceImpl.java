package com.example.usersService.service;

import com.example.usersService.model.User;
import com.example.usersService.repository.UserRepository;
import com.example.usersService.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {


    private final UserRepository userRepository;
    private final UserValidator userValidator;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void createUser(User user) {

        userValidator.validateUsername(user.getUsername());

        //encrypt the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

    }



    @Override
    public User getUserDetails() {
        return null;
    }

    @Override
    public User getUserDetails(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
