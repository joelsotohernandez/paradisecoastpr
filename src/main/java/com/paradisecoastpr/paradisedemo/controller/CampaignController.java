package com.paradisecoastpr.paradisedemo.controller;

import com.paradisecoastpr.paradisedemo.model.Campaign;
import com.paradisecoastpr.paradisedemo.model.Post;
import com.paradisecoastpr.paradisedemo.repository.CampaignRepository;
import com.paradisecoastpr.paradisedemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class CampaignController {

    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private PostRepository postRepository;



    @GetMapping("/campaigns")
    public List<Campaign> getCampaigns()
    {
        return campaignRepository.findAll();
    }

    @PostMapping("/campaigns")
    public Campaign createCampaign(@Valid @RequestBody Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @PutMapping("/campaigns/{campaignId}/{postId}")
    public Campaign addPost(@PathVariable Long postId, @PathVariable Long campaignId)
    {
        Optional<Post> optPost = postRepository.findById(postId);
        Optional<Campaign> optTag = campaignRepository.findById(campaignId);

        if (!optPost.isPresent() || !optTag.isPresent()) {
            throw  new EntityNotFoundException("This post was not found");
        }

        Post post = optPost.get();
        Campaign campaign = optTag.get();
        campaign.getPosts().add(post);
        campaignRepository.save(campaign);
        return campaign;
    }

    @PutMapping("/campaigns/{campaignId}/remove/{postId}")
    public Campaign removePost(@PathVariable Long postId, @PathVariable Long campaignId)
    {
        Optional<Post> optPost = postRepository.findById(postId);
        Optional<Campaign> optTag = campaignRepository.findById(campaignId);

        if (optPost.isPresent() && optTag.isPresent()) {
            throw  new EntityNotFoundException("This post was not found");

        }
        Post post = optPost.get();
        Campaign campaign = optTag.get();
        campaign.getPosts().remove(post);
        campaignRepository.save(campaign);
        return campaign;
    }

    @PostMapping("/campaigns/withpost/{postId}")
    public List<Campaign> getByPostID(@PathVariable Long postId)
    {
        Optional<Post> optPost = postRepository.findById(postId);

        if (!optPost.isPresent()) {
            throw  new EntityNotFoundException("This post was not found");
        }
        Post post = optPost.get();
        List<Campaign> campaigns = campaignRepository.findByPosts(post);
        return campaigns;

    }


}