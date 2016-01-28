package com.postazure.auth;

import com.postazure.user.User;
import com.postazure.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by postazure on 1/27/16.
 */
@Service
public class AuthService {

    @Autowired
    UserService userService;

    public boolean authenticate(String email, String password) {
        User user = userService.getUser(email);
        return BCrypt.checkpw(password, user.getPassword());
    }

    public String establishToken(String email) {
        String token = generateToken();
        userService.setToken(email, token);
        return token;
    }

    public String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        return new BigInteger(130, secureRandom).toString(32);
    }

}
