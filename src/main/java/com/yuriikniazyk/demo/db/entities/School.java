package com.yuriikniazyk.demo.db.entities;

import com.yuriikniazyk.demo.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name="Schools")
public class School {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Status status;

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Status getStatus() { return status; }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(Status status) { this.status = status; }
}
