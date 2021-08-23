package com.SIT.codeDR.controllers;

import com.SIT.codeDR.models.Module;
import com.SIT.codeDR.models.Role;
import com.SIT.codeDR.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ModuleController {

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/roles")
    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/hello")
    public String test() {
        return "hello";
    }
}
