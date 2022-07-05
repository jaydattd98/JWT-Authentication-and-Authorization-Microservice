package com.cognizant.springboot.jwtauthentication.service;

import com.cognizant.springboot.jwtauthentication.model.User;
import com.cognizant.springboot.jwtauthentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Class MyUserDetailsService
 * <p>
 * Used to provide Customer UserDetails service
 *
 * @author jaydatt
 */
@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails
                .User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}
