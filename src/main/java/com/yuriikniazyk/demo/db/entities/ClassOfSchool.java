package com.yuriikniazyk.demo.db.entities;

import com.yuriikniazyk.demo.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name="Classes")
public class ClassOfSchool {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
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
    public Status getStatus() { return status; }
    public School getSchool() { return school; }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(Status status) { this.status = status; }
    public void setSchool(School school) { this.school = school; }
}
