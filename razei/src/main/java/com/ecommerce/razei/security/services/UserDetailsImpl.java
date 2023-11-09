package com.ecommerce.razei.security.services;

import com.ecommerce.razei.models.RazeiUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private final RazeiUser razeiUser;

    public UserDetailsImpl(RazeiUser razeiUser) {
        this.razeiUser = razeiUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public String getPassword() {
        return razeiUser.getPassword();
    }

    @Override
    public String getUsername() {
        return razeiUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getMail(){return razeiUser.getEmail();}
}
