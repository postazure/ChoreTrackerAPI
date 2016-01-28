package com.postazure.auth;

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

    public boolean authenticate(String providedPassword, String dbPassword) {
        return BCrypt.checkpw(providedPassword, dbPassword);
    }

    public String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        return new BigInteger(130, secureRandom).toString(32);
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
