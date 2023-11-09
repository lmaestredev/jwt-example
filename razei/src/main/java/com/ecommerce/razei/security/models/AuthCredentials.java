package com.ecommerce.razei.security.models;


public class AuthCredentials {
    private String username;
    private String password;

    public AuthCredentials() {
    }

    public AuthCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getusername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
