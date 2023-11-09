package com.ecommerce.razei.services;

import com.ecommerce.razei.models.RazeiUser;
import com.ecommerce.razei.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RazeiUser getUserByUsername(String username){
        return userRepository.findOneByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " doesn't exist"));
    }

    @Override
    public void saveUser(RazeiUser razeiUser) {
        userRepository.save(razeiUser);
    }
}
