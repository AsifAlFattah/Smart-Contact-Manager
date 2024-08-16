package com.codeprophet.scm2.services.impl;

import com.codeprophet.scm2.entities.User;
import com.codeprophet.scm2.helpers.ResourceNotFoundException;
import com.codeprophet.scm2.repositories.UserRepo;
import com.codeprophet.scm2.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        // Generate UserID
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 =  userRepo.findById(user.getUserId()).orElseThrow( () -> new ResourceNotFoundException("User Not Found."));
        // Update user2 with user
        user2.setUserName(user.getUserName());
        user2.setUserEmail(user.getUserEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePicture(user.getProfilePicture());
        user2.setEnabled(user.getEnabled());
        user2.setEmailVerified(user.getEmailVerified());
        user2.setPhoneVerified(user.getPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());

        User save = userRepo.save(user2);

        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User user2 =  userRepo.findById(id).orElseThrow( () -> new ResourceNotFoundException("User Not Found."));
        userRepo.delete(user2);
    }

    @Override
    public boolean userExists(String id) {
        User user2 =  userRepo.findById(id).orElse(null);

        return user2!=null ? true : false;
    }

    @Override
    public boolean userExistsByEmail(String email) {
        User user = userRepo.findByUserEmail(email).orElse(null);
        return user!=null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
