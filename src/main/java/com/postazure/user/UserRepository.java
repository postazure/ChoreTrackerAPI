package com.postazure.user;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by postazure on 1/27/16.
 */
public interface UserRepository extends CrudRepository<User, Long>{

    User findFirstByEmail(String email);
}
