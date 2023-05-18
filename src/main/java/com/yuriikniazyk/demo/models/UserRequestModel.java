package com.yuriikniazyk.demo.models;

import com.yuriikniazyk.demo.enums.UserRole;
import jakarta.validation.constraints.*;

public class UserRequestModel {
    @Size(min=2, max=300)
    private String name;
    @Size(min=2, max=300)
    private String surname;
    @Email(message = "Email must be valid")
    private String email;
    @NotNull(message = "Role must be valid enum value")
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
