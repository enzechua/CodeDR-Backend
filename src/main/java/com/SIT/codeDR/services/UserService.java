package com.SIT.codeDR.services;

import com.SIT.codeDR.models.User;
import com.SIT.codeDR.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User request) {
//        if (userRepository.existsByUsername(request.getUsername())) {
//            throw new ValidationException("username exists");
//        }
        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        userRepository.save(request);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Load userbyusername is called");
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }

}
