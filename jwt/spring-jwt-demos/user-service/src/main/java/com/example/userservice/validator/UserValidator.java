package com.example.userservice.validator
        ;

import com.example.userservice.exception.UserAlreadyExistsException;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserValidator {

   private final UserRepository userRepository;


   public void validUsername(final String username){
       boolean isUserExists = userRepository.existsByUsername(username);
       if(isUserExists) {
           throw new UserAlreadyExistsException("User is already exists with username : " + username);
       }
   }





}
