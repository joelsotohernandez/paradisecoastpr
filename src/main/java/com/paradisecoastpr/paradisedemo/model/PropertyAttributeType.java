package com.paradisecoastpr.paradisedemo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name = "property_attribute_type")
public class PropertyAttributeType extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

}
