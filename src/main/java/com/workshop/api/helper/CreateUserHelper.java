package com.workshop.api.helper;

import com.workshop.api.dataproviders.JsonDataProvider;
import com.workshop.api.model.User;
import com.workshop.api.mapper.CreateUserMapper;
import com.workshop.api.util.Utilities;
import io.restassured.response.Response;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class CreateUserHelper {

    public Response createUser() throws FileNotFoundException {
        JsonDataProvider jsonDataProvider = new JsonDataProvider();
        CreateUserMapper createUserMapper = new CreateUserMapper();

        String userJob = Utilities.getProperty("use.data.test");
        User user = createUserMapper.setUserRequest(jsonDataProvider.getUser(userJob));

        return given()
                .when()
                .body(user)
                .post("users")
                .then()
                .extract().response();
    }


}
