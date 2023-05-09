package com.yuriikniazyk.demo.models;

import com.yuriikniazyk.demo.enums.UserRole;

public class UserRequestModel {
    private String name;
    private String surname;
    private String email;
    private UserRole role;

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public UserRole getRole() {
        return role;
    }
}
