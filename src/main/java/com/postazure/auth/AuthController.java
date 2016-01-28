package com.postazure.auth;

import com.postazure.user.User;
import com.postazure.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

/**
 * Created by postazure on 1/27/16.
 */

@Controller
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/token", method = RequestMethod.POST, produces = "application/json")
    public Map<String, String> getToken(@RequestBody AuthFormModel provided) {
        String token = null;
        User user = userService.getUser(provided.getEmail());

        if (authService.authenticate(provided.getPassword(), user.getPassword())) {
            token = authService.generateToken();
            userService.saveToken(user, token);
        }

        return Collections.singletonMap("token", token);
    }
}
