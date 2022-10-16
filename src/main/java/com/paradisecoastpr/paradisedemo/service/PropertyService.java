package com.paradisecoastpr.paradisedemo.service;

import com.paradisecoastpr.paradisedemo.model.Property;
import com.paradisecoastpr.paradisedemo.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PropertyService {

    @Autowired
    PropertyRepository repo;

    public List<Property> findAll() {
        return repo.findAll();
    }

    public Optional<Property> getByID(Long id) {
        return repo.findById(id);
    }

}
