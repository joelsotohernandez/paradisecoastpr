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
import java.util.Set;


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

    @PutMapping("/posts/{postId}/add/{tagId}")
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


    @PostMapping("/post/tag/search")
    public Set<Post> postBody(@RequestBody String name) {
        Set<Tag> tags = tagRepository.findByNameContaining(name);
        Set<Post> posts = postRepository.findByTagsIn(tags);
        return posts;
    }

    @PostMapping("/post/tag/direct/search")
    public Set<Post> getPostByTag(@RequestBody String name) {
        Set<Post> posts = postRepository.findByTags_NameContaining(name);
        return posts;
    }

}
