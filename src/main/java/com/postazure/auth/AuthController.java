package com.postazure.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by postazure on 1/27/16.
 */

@Controller
public class AuthController {

    @Autowired
    AuthService authService;

    @ResponseBody
    @RequestMapping(value = "/token", method = RequestMethod.POST, produces = "application/json")
    public String getToken(@RequestBody String email, @RequestBody String password) {
        String token = null;
        if (authService.authenticate(email, password)) {
            token = authService.establishToken(email);
        }
        return token;
    }
}
