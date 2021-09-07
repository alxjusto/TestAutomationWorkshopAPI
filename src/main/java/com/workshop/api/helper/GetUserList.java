package com.workshop.api.helper;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetUserList {

    public Response getUserList() {
        return given()
                .get("users?page=1")
                .then()
                .extract().response();
    }
}
