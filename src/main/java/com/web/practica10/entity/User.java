package com.web.practica10.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int userId;

    private String username;

    private String password;

    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> rolSet;

    public User() {

    }

    public User(String name, String password, boolean enabled, Set<Role> rolSet) {
        super();
    this.username = name;
    this.password = password;
    this.enabled = enabled;
    this.rolSet = rolSet;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRolSet() {
        return rolSet;
    }

    public void setRolSet(Set<Role> rolSet) {
        this.rolSet = rolSet;
    }
}