package com.yuriikniazyk.demo.models;

import com.yuriikniazyk.demo.enums.UserRole;

public class UserRequestModel {
    private String name;
    private String surname;
    private String email;
    private UserRole role;
    private int schoolId;

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
    public int getSchoolId() { return schoolId; }
}
