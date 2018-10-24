package com.patrycja.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Animal {

    private int id;
    private String name;
    private String type;
    private String description;

    public Animal(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }
}
