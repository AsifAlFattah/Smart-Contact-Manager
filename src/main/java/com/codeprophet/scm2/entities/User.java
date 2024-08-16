package com.codeprophet.scm2.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private  String userId;
    @Column(name = "userName", nullable = false)
    private  String userName;
    @Column(unique = true, nullable = false)
    private String userEmail;
    private String phoneNumber;
    private  String password;
    @Column(length = 10000)
    private String about;
    private String profilePicture;
    private Boolean enabled = false;
    private Boolean emailVerified = false;
    private Boolean phoneVerified = false;

//    Self, Google, Facebook, GitHub, LinkedIn
    @Enumerated(value = EnumType.STRING)
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();





}
