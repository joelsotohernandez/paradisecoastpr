package com.paradisecoastpr.paradisedemo.repository;

import com.paradisecoastpr.paradisedemo.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface PropertyRepository extends JpaRepository<Property, Long > {
}
