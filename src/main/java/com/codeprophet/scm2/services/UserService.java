package com.codeprophet.scm2.services;

import com.codeprophet.scm2.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);
    Optional<User> getUserById(String id);
    Optional<User> updateUser(User user);
    void deleteUser(String id);
    boolean userExists(String id);
    boolean userExistsByEmail(String email);
    List<User> getAllUsers();

}
