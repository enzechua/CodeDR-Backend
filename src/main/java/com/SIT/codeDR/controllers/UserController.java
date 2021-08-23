package com.SIT.codeDR.controllers;

import com.SIT.codeDR.dto.UserDTO;
import com.SIT.codeDR.models.User;
import com.SIT.codeDR.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class UserController {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

//    @PostMapping("/signup")
//    public void signUp(@RequestBody User user) {
////        ApplicationUser user = modelMapper.map(userDto, ApplicationUser.class);
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }

    @GetMapping("/signup")
//    @RolesAllowed(Role)
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
