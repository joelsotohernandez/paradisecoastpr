package com.paradisecoastpr.paradisedemo.controller;

import com.paradisecoastpr.paradisedemo.model.Property;
import com.paradisecoastpr.paradisedemo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@EnableTransactionManagement
@Transactional
public class PropertyController {

    @Autowired
    PropertyService service;

    @GetMapping("/all")
    public List<Property> getAll(){

        List<Property> result;
        result = service.findAll();
        return result;

    }

    @GetMapping("/{propertyID}")
    public Optional<Property> getByID(
            @PathVariable Long id
    ){
        Optional<Property> result;
        return result = service.getByID(id);
    }

}
