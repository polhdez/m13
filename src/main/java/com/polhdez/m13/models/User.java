package com.polhdez.m13.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    private String username, password;
    private long id;
    private Boolean logged;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.logged = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "logged", nullable = false)
    public Boolean getLogged() {
        return logged;
    }
    public void setLogged(boolean logged) {
        this.logged = logged;
    }

}
