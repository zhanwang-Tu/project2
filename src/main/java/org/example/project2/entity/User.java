package org.example.project2.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    protected Long id;
    protected String username;
    protected String password;
    protected String fullName;
    protected String email;
    protected String phoneNumber;
    protected String address;
    protected int age;
    protected String gender;
    protected Date dateOfBirth;


}
