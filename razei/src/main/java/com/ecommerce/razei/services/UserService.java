package com.ecommerce.razei.services;


import com.ecommerce.razei.models.RazeiUser;

public interface UserService {

    public RazeiUser getUserByUsername(String username);
    public void saveUser(RazeiUser razeiUser);
}
