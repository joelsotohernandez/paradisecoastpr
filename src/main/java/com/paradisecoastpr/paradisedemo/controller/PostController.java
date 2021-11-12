package com.paradisecoastpr.paradisedemo.controller;

import com.paradisecoastpr.paradisedemo.model.Post;
import com.paradisecoastpr.paradisedemo.model.Tag;
import com.paradisecoastpr.paradisedemo.repository.PostRepository;
import com.paradisecoastpr.paradisedemo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;


    @GetMapping("/posts")
    public List<Post> getPosts()
    {
        return postRepository.findAll();
    }

    @PutMapping("/posts/{postId}/{tagId}")
    public String  addTag(@PathVariable Long postId, @PathVariable Long tagId)
    {
        Optional<Post> optPost = postRepository.findById(postId);
        Optional<Tag> optTag = tagRepository.findById(tagId);

        if (optPost.isPresent() && optTag.isPresent()) {
            Post post = optPost.get();
            Tag tag = optTag.get();
            post.getTags().add(tag);
            postRepository.save(post);
            return "yup";
        }

        return "nope";
    }

    @PutMapping("/posts/{postId}/remove/{tagId}")
    public String  removeTag(@PathVariable Long postId, @PathVariable Long tagId)
    {
        Optional<Post> optPost = postRepository.findById(postId);
        Optional<Tag> optTag = tagRepository.findById(tagId);

        if (optPost.isPresent() && optTag.isPresent()) {
            Post post = optPost.get();
            Tag tag = optTag.get();
            post.getTags().remove(tag);
            postRepository.save(post);
            return "yup";
        }

        return "nope";
    }







}
