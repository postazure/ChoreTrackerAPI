package com.postazure.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

/**
 * Created by postazure on 1/27/16.
 */

@Controller
@RequestMapping("/users")
@ResponseBody
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public User show(@PathVariable Long id) {
        User users = userService.getUser(id);
        return users;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Map<String, String> create(@RequestBody UserFormModel userFormModel) {

        User user = userService.createUser(
                userFormModel.getFirstName(),
                userFormModel.getLastName(),
                userFormModel.getEmail(),
                userFormModel.getPassword());

        Map<String, String> token = Collections.singletonMap("token", user.getToken());

        return token;

    }

}
