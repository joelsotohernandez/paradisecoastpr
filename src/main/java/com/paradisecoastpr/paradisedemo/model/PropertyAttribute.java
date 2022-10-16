package com.paradisecoastpr.paradisedemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@Table(name = "property_attribute")
public class PropertyAttribute extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="type_id")
    private PropertyAttributeType type;

    @ManyToOne
    @JsonBackReference(value="property-attributes")
    @JoinColumn(name="property_id", nullable=false)
    Property property;

    @NotNull
    @Size(max = 250)
    private String description;

}
