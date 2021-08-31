package com.workshop.api.mapper;

import com.workshop.api.model.User;

public class CreateUserMapper {

    public User setUserRequest(User user) {
        return User.builder()
                .name(user.getName())
                .job(user.getJob())
                .build();
    }
}
