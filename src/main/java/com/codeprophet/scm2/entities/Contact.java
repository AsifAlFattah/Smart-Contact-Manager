package com.codeprophet.scm2.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Contact {
    @Id
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String picture;
    @Column(length = 10000)
    private String description;
    private boolean favorite = false;
    private String websiteLink;
    private  String LinkedInLink;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();

}
