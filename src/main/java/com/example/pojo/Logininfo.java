package com.example.pojo;

import javax.persistence.*;

public class Logininfo {
    @Id
    private Long id;

    private String username;

    private String password;

    private int state;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return state
     */
    public int getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }
}