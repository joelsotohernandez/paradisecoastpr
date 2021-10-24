package com.paradisecoastpr.paradisedemo.repository;


import com.paradisecoastpr.paradisedemo.model.Campaign;
import com.paradisecoastpr.paradisedemo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 22/11/17.
 */
@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

}
