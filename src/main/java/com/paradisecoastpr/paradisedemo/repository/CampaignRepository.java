package com.paradisecoastpr.paradisedemo.repository;


import com.paradisecoastpr.paradisedemo.model.Campaign;
import com.paradisecoastpr.paradisedemo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findByPosts(Post post);
}
