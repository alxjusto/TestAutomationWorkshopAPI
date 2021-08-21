package com.workshop.api.tests;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UsuariosTest {

    private static RequestSpecification requestSpecification;


    @BeforeAll
    public static void setUp() {
        requestSpecification = given()
                .baseUri("https://reqres.in")
                .basePath("/api")
                .contentType(ContentType.JSON);
    }

    @Test
    public void obtenerListadoDeUsuarioTest() {

        String response = given(requestSpecification)
                .get("users?page=1")
                .then()
                .extract()
                .asString();

        System.out.println(response);
    }

    @Test
    public void crearUsuarioTest() {

        String response = given(requestSpecification)
                .body("{\n" +
                        "    \"name\": \"pepe\",\n" +
                        "    \"job\": \"tester\"\n" +
                        "}")
                .post("users")
                .then()
                .extract()
                .asString();

        System.out.println(response);
    }

    @Test
    public void actualizarUsuarioTest() {

        String response = given(requestSpecification)
                .body("{\n" +
                        "    \"name\": \"ana\",\n" +
                        "    \"job\": \"dev\"\n" +
                        "}")
                .put("users/1")
                .then()
                .extract()
                .asString();

        System.out.println(response);
    }

}
