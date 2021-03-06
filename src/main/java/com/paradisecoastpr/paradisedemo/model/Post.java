package com.paradisecoastpr.paradisedemo.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "post")

public class Post extends AuditModel{

    //columns////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String title;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();

    @ManyToMany(fetch = FetchType.EAGER ,
            cascade = {
                CascadeType.ALL
            })
    @JoinTable(name = "xref_post_tag",
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    private  Set<Tag> tags = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER ,
            mappedBy = "posts")
    private Set<Campaign> campaigns = new HashSet<>();


    //constructors////////////////////////////
    public Post() { }

    public Post(String title, String description) {
        this.title = title;
        this.description = description;

    }

    //Getter/Setters////////////////////////////
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getPostedAt() {
        return postedAt;
    }
    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }
    public Set<Tag> getTags() {
        return tags;
    }
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
