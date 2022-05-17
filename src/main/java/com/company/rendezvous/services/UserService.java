package com.company.rendezvous.services;

import com.company.rendezvous.entities.User;

public interface UserService {
    void save(User user);
    User findByUserName(String userName);
}
