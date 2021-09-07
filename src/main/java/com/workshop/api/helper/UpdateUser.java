package com.workshop.api.helper;

import com.workshop.api.dataproviders.JsonDataProvider;
import com.workshop.api.mapper.CreateUserMapper;
import com.workshop.api.model.User;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class UpdateUser {


    public Response updateUser() throws FileNotFoundException {
        String userJob = "tester";
        JsonDataProvider jsonDataProvider = new JsonDataProvider();
        CreateUserMapper createUserMapper = new CreateUserMapper();
        User user = createUserMapper.setUserRequest(jsonDataProvider.getUser(userJob));

        return given()
                .body(user)
                .put("users/1")
                .then()
                .extract().response();
    }


}
