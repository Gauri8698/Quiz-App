package com.quizeserver.service.user;

import com.quizeserver.entities.User;

public interface UserService {

    User createUser(User user);

    Boolean hasUserWithEmail(String email);

    User login(User user);
}
