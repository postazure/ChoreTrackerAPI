package com.postazure.models.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by postazure on 1/27/16.
 */
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findByEmail(String email);
}
