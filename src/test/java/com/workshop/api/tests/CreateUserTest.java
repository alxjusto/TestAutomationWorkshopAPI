package com.workshop.api.tests;

import com.workshop.api.helper.BaseTest;
import com.workshop.api.helper.CreateUser;
import com.workshop.api.helper.GetUserList;
import com.workshop.api.helper.UpdateUser;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class CreateUserTest extends BaseTest {

    @Test
    public void getUserListTest() {
        GetUserList userList = new GetUserList();
        Response response = userList.getUserList();
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void createUserTest() throws Exception {
        CreateUser createUser = new CreateUser();
        Response response = createUser.createUser();
        Assertions.assertEquals(201, response.getStatusCode());
    }

    @Test
    public void updateUserTest() throws FileNotFoundException {
        UpdateUser user = new UpdateUser();
        Response response = user.updateUser();
        Assertions.assertEquals(200, response.getStatusCode());
    }

}
