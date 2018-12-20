package com.web.practica10.repositories;

import com.web.practica10.entity.Role;
import com.web.practica10.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByRolSet(Set<Role> rol);
    User findByUsername(String name);
    User findByPassword(String password);
    User findByUserId(int id);

    List<User> findAllByEnabled(Boolean enabled);


}
