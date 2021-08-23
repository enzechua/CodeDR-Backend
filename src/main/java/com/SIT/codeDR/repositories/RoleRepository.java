package com.SIT.codeDR.repositories;

import com.SIT.codeDR.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
