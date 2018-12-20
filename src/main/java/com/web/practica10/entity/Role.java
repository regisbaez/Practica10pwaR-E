package com.web.practica10.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue
    private int roleId;

    private String roleName;

    public Role() {

    }

    public Role(String rolename) {
        super();
        this.roleName = rolename;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
