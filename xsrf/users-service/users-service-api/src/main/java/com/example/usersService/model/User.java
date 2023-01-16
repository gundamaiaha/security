package com.example.usersService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "APP_USERS")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String username;
    private String password;
  //  private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;


}
