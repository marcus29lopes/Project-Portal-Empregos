package com.marcus.jobportal.services;

import com.marcus.jobportal.entity.Users;
import com.marcus.jobportal.repository.UsersRepository;
import com.marcus.jobportal.util.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final UsersRepository usersRepository;

    @Autowired
    public CustomUserDetailsService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    //tell spring security how to retrieve a user form database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user = usersRepository.findByEmail(username).orElseThrow(()->
               new UsernameNotFoundException("Could not find user"));
        return new CustomUserDetails(user);
    }
}
