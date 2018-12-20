package com.web.practica10.repositories;

import com.web.practica10.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Role,Integer> {
    Role findByRoleName(String rolName);
}
