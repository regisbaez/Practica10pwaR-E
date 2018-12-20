package com.web.practica10.service;

import com.web.practica10.entity.Role;
import com.web.practica10.entity.User;
import com.web.practica10.repositories.RolRepository;
import com.web.practica10.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User appUser = userRepository.findByUsername(username);

        if (appUser == null) {
            System.out.println("No se encontro usuario! " + username);
            throw new UsernameNotFoundException("Usuario " + username + " no esta en la BD");
        }

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for(Role role : appUser.getRolSet()){
            roles.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), appUser.isEnabled(), true, true, true, grantedAuthorities);
    }

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void createAdmin(){
        if (!findAdmin()){
            Role rol = new Role("ROLE_ADMIN");
            rolRepository.save(rol);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setEnabled(true);
            admin.setRolSet(new HashSet<>(Arrays.asList(rol)));

           userRepository.save(admin);
        }
    }

    private boolean findAdmin(){
        Role rol = rolRepository.findByRoleName("ROLE_ADMIN");
        if(rol == null){
            return  false;
        }
        return true;
    }

}