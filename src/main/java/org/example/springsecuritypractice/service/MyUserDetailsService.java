package org.example.springsecuritypractice.service;

import org.example.springsecuritypractice.entity.User;
import org.example.springsecuritypractice.entity.UserPrincipal;
import org.example.springsecuritypractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username: " + username);
        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("User with username " + username + " not found");
            throw new UsernameNotFoundException("User with username " + username + " not found!");
        }
        return new UserPrincipal(user);
    }
}
