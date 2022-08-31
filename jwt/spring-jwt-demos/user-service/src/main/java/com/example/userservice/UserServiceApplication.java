package com.example.userservice;

import com.example.userservice.model.Role;
import com.example.userservice.model.User;
import com.example.userservice.repository.RoleRepository;
import com.example.userservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

    @Bean
	CommandLineRunner run(final RoleRepository roleRepository, final UserRepository userRepository, final PasswordEncoder encoder){
		return args -> {
			//create roles
			Role adminRole = new Role(1L,"ROLE_ADMIN");
			Role userRole= new Role(2L, "ROLE_USER");
			roleRepository.saveAll(List.of(adminRole,userRole));

			//create admin user
			Role admin_Role = roleRepository.findById(1L).get();
			User adminUser = new User(null,"John","john", encoder.encode("admin123"),Arrays.asList(admin_Role));
			userRepository.save(adminUser);


		};
	}



	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}
