package com.SIT.codeDR.repositories;

import com.SIT.codeDR.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
}
