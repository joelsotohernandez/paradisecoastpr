package com.paradisecoastpr.paradisedemo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Data
@Table(name = "property")
public class Property extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    @Column(unique = true)
    private String description;

    @OneToMany(mappedBy = "property")
    @JsonManagedReference(value = "property-attributes")
    private List<PropertyAttribute> attributes;

}
