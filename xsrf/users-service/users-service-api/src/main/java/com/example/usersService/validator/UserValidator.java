package com.example.usersService.validator;

import com.example.usersService.exception.UsernameAlreadyExistsException;
import com.example.usersService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserValidator {


    private final UserRepository userRepository;


    public void validateUsername(final String username){
       boolean isUserAlreadyExists=  userRepository.existsByUsername(username);
       if(isUserAlreadyExists){
           log.error("username is already exists in DB");
           throw new UsernameAlreadyExistsException("username is already taken");
       }
    }


}
