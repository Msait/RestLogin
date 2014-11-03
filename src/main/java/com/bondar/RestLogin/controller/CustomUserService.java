package com.bondar.RestLogin.controller;

import com.bondar.RestLogin.data.UserDao;
import com.bondar.RestLogin.model.Role;
import com.bondar.RestLogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bondar K. on 04.11.14.
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(username);
        if ( user == null ) {
            throw new UsernameNotFoundException("No user found");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        org.springframework.security.core.userdetails.User userDetailService = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
        return userDetailService;
    }
}
