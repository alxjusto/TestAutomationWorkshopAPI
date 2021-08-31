package com.workshop.api.tests;

import com.workshop.api.model.User;
import com.workshop.api.helper.BaseTestHelper;
import com.workshop.api.helper.CreateUserHelper;
import com.workshop.api.mapper.CreateUserMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest extends BaseTestHelper {

    @Test
    public void getUserListTest() {
        given()
                .get("users?page=1")
                .then();
    }

    @Test
    public void createUserTest() throws Exception {
        CreateUserHelper createUserHelper = new CreateUserHelper();
        Response response = createUserHelper.createUser();
        Assertions.assertEquals(201, response.getStatusCode());
    }

    @Test
    public void updateUserTest() {

        CreateUserMapper createUserMapper = new CreateUserMapper();
        User user = createUserMapper.setUserRequest(new User("ana", "dev"));

        given()
                .body(user)
                .put("users/1")
                .then();
    }

}
