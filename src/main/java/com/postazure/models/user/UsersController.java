package com.postazure.models.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by postazure on 1/27/16.
 */

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Iterable<User> index() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User show(@PathVariable Long id) {
        User users = userRepository.findOne(id);
        return users;
    }

}
