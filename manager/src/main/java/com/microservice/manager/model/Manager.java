package com.microservice.manager.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer Id;
    @Column(name="manager_name")
    private String name;

    @Transient
    private List<Developers> developersList;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Developers> getDevelopersList() {
        return developersList;
    }

    public void setDevelopersList(List<Developers> developersList) {
        this.developersList = developersList;
    }

}
