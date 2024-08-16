package com.codeprophet.scm2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    // User Dashboard Page
    @RequestMapping(value = "/dashboard")
    public String dashboard() {

        return "user/dashboard";
    }

    // User Profile Page
    @RequestMapping(value = "/profile")
    public String profile() {

        return "user/profile";
    }

    // User Add Contact Page


    // User View Contact Page


    // User Edit Contact Page


    // User Delete Contact Page

}
