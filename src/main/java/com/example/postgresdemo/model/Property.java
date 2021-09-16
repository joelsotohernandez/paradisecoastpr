package com.example.postgresdemo.model;


import javax.persistence.*;

@Entity
@Table(name="property")
public class Property {
    @Id
    @GeneratedValue(generator = "property_generator")
    @SequenceGenerator(
            name = "property_generator",
            sequenceName = "property_sequence",
            initialValue = 1000
    )
    private Long id;
    private String name;
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
