package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Property;
import com.example.postgresdemo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyReporistory extends JpaRepository<Property, Long> {

}
