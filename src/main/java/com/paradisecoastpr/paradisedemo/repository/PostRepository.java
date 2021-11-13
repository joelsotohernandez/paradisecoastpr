package com.paradisecoastpr.paradisedemo.repository;


import com.paradisecoastpr.paradisedemo.model.Post;
import com.paradisecoastpr.paradisedemo.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
        Set<Post> findByTagsIn(Set<Tag> tags);
        Set<Post> findByTags_NameContaining(String name);
}