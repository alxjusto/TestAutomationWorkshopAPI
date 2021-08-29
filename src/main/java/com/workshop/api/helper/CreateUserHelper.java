package com.workshop.api.helper;

import com.workshop.api.dataproviders.JsonDataProvider;
import com.workshop.api.dto.User;
import com.workshop.api.mapper.UsuarioMapper;
import com.workshop.api.util.Utilities;
import io.restassured.response.Response;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class CreateUserHelper {

    public Response createUser() throws FileNotFoundException {
        JsonDataProvider jsonDataProvider = new JsonDataProvider();
        UsuarioMapper usuarioMapper = new UsuarioMapper();

        String userJob = Utilities.getProperty("use.data.test");
        User user = usuarioMapper.setUsuarioRequest(jsonDataProvider.getUser(userJob));

        return given()
                .when()
                .body(user)
                .post("users")
                .then()
                .extract().response();
    }


}
