package com.example.postgresdemo.controller;
import com.example.postgresdemo.model.Room;
import com.example.postgresdemo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping("/rooms")
    public Room createQuestion(@Valid @RequestBody Room room) {
        return roomRepository.save(room);
    }

    @GetMapping("/rooms/{id}")
    public Optional<Room> getRoom(@PathVariable Long id)
    {
     return roomRepository.findById(id);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms()
    {
        return roomRepository.findAll();
    }
}
