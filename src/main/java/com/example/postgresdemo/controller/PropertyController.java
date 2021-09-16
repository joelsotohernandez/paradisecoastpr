package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.Room;
import com.example.postgresdemo.repository.AnswerRepository;
import com.example.postgresdemo.repository.PropertyReporistory;
import com.example.postgresdemo.repository.QuestionRepository;
import com.example.postgresdemo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyReporistory propertyReporistory;
    private RoomRepository roomRepository;

    @GetMapping("/property-rooms/{propertyId}")
    public List<Room> getAnswersByQuestionId(@PathVariable Long propertyId) {
        return roomRepository.findByPropertyId(propertyId);
    }

}
