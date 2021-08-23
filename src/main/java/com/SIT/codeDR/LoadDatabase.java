package com.SIT.codeDR;

import com.SIT.codeDR.models.Permission;
import com.SIT.codeDR.models.Role;
import com.SIT.codeDR.repositories.PermissionRepository;
import com.SIT.codeDR.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RoleRepository roleRepository, PermissionRepository permissionRepository) {

        return args -> {
            log.info("Preloading " + permissionRepository.save(new Permission("Read_Only", "Only able to access views")));
            log.info("Preloading " + permissionRepository.save(new Permission("Write_Only", "Only able to Create Stuffs")));
            log.info("Preloading " + permissionRepository.save(new Permission("All", "Both Read and Write")));
            log.info("Preloading " + roleRepository.save(new Role("System Admin", "System Admin")));
            log.info("Preloading " + roleRepository.findByName("System Admin").getId());
            log.info("Preloading " + roleRepository.save(new Role("Professor", "Professor")));
            log.info("Preloading " + roleRepository.save(new Role("Student", "Student")));
        };
    }
}