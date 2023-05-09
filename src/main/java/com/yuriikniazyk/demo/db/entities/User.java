package com.yuriikniazyk.demo.db.entities;

import com.yuriikniazyk.demo.enums.Status;
import com.yuriikniazyk.demo.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private UserRole role;
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="schoolId", nullable=false)
    private School school;

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() { return surname; }
    public String getEmail() {
        return email;
    }
    public UserRole getRole() { return role; }
    public Status getStatus() { return status; }
    public School getSchool() { return school; }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) { this.surname = surname; }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRole(UserRole role) { this.role = role; }
    public void setStatus(Status status) { this.status = status; }
    public void setSchool(School school) { this.school = school; }
}