package com.haegerconsulting.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "ID")
    private Long id;
    @Column (name = "USER_NAME")
    private String userName;
    @Column (name = "LAST_NAME")
    private String lastName;
    @Column (name = "FIRST_NAME")
    private String firstName;
    @Column (name = "EMAIL")
    private String email;
    @Column (name = "PASSWORD")
    private String password;
}
