package com.paradisecoastpr.paradisedemo.controller;

import com.paradisecoastpr.paradisedemo.model.Campaign;
import com.paradisecoastpr.paradisedemo.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
public class CampaignController {

    @Autowired
    private CampaignRepository campaignRepository;


    @GetMapping("/campaigns")
    public List<Campaign> getCampaigns()
    {
        return campaignRepository.findAll();
    }


    @PostMapping("/campaigns")
    public Campaign createCampaign(@Valid @RequestBody Campaign campaign) {
        return campaignRepository.save(campaign);
    }

}