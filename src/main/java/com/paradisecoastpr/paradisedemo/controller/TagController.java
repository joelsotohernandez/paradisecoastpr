package com.paradisecoastpr.paradisedemo.controller;


import com.paradisecoastpr.paradisedemo.model.Tag;
import com.paradisecoastpr.paradisedemo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class TagController {

    @Autowired
    private TagRepository tagRepository;


    @GetMapping("/tags")
    public List<Tag> getTags()
    {
        return tagRepository.findAll();
    }

    @PostMapping("/tags")
    public Tag createTag(@Valid @RequestBody Tag tag) {
        return tagRepository.save(tag);
    }

}
