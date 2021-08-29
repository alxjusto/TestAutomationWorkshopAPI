package com.workshop.api.mapper;

import com.workshop.api.dto.User;

public class UsuarioMapper {

    User userBodyRequest = new User();

    public User setUsuarioRequest(User user) {
        userBodyRequest.setName(user.getName());
        userBodyRequest.setJob(user.getJob());
        return userBodyRequest;
    }
}
