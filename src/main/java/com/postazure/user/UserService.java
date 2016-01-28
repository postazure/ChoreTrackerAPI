package com.postazure.user;

import com.postazure.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by postazure on 1/27/16.
 */

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthService authService;

    public void saveToken(User user, String token) {
        user.setToken(token);
        userRepository.save(user);
    }

    public User getUser(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    public User createUser(String firstName, String lastName, String email, String password) {
        String hashedPassword = authService.hashPassword(password);
        User user = new User(firstName, lastName, email, hashedPassword);
        user.setToken(authService.generateToken());
        userRepository.save(user);
        return user;
    }
}
