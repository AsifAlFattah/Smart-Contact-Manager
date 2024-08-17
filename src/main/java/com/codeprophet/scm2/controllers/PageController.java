package com.codeprophet.scm2.controllers;

import com.codeprophet.scm2.entities.User;
import com.codeprophet.scm2.forms.UserForm;
import com.codeprophet.scm2.helpers.Message;
import com.codeprophet.scm2.helpers.MessageType;
import com.codeprophet.scm2.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String homePage(Model model){
//        System.out.println("Homepage handler.");

        // Sending data to view
        model.addAttribute("title", "Home Page");
        model.addAttribute("heading","Welcome to Home Page!");
        model.addAttribute("test", "This is dynamic text.");
        model.addAttribute("url","https://docs.google.com/document/d/1GHA-IyWvO7Gh8lMLHsV5KKp-pJFi9Sbb2lWEMXAZ7Eg/edit");

        return "home";
    }

    // About Routing
    @RequestMapping("/about")
    public String aboutPage(Model model){
        return "about";
    }

    // Services Routing
    @RequestMapping("/services")
    public String servicesPage(Model model){
        return "services";
    }

    // Contact Routing
    @RequestMapping("/contact")
    public String contactPage(Model model){
        return "contact";
    }

    // Login Routing
    @RequestMapping("/login")
    public String loginPage(Model model){
        return "login";
    }

    // SignUp Routing
    @RequestMapping("/register")
    public String registerPage(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        return "register";
    }

    // Processing Register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){
        System.out.println("Processing register page");

        // fetch form data
        // validate form data
        if(rBindingResult.hasErrors()){
            return "register";
        }
        // save to database
        // User Service
//        User user = User.builder()
//                .userName(userForm.getUserName())
//                .userEmail(userForm.getUserEmail())
//                .password(userForm.getPassword())
//                .about(userForm.getAbout())
//                .phoneNumber(userForm.getPhoneNumber())
//                .profilePicture("https://static.vecteezy.com/system/resources/previews/005/544/718/non_2x/profile-icon-design-free-vector.jpg")
//                .build();

        User user = new User();
        user.setUserName(userForm.getUserName());
        user.setPassword(userForm.getPassword());
        user.setUserEmail(userForm.getUserEmail());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePicture("https://static.vecteezy.com/system/resources/previews/005/544/718/non_2x/profile-icon-design-free-vector.jpg");


        User savedUser = userService.saveUser(user);
        System.out.println("User saved");
        // message = "Registration Successful"
        Message message = Message.builder().message("Registration Successfull!").type(MessageType.green).build();
        session.setAttribute("message", message);

        // Redirect to Login Page
        return "redirect:/register";
    }


}
