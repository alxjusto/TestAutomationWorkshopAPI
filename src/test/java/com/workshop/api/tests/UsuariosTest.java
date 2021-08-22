package com.workshop.api.tests;

import com.workshop.api.dto.Usuario;
import com.workshop.api.mapper.UsuarioMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UsuariosTest {

    private static RequestSpecification requestSpecification;


    @BeforeAll
    public static void setUp() {
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .addFilters(filters)
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void obtenerListadoDeUsuarioTest() {
        given(requestSpecification)
                .get("users?page=1")
                .then();
    }


    @Test
    public void crearUsuarioTest() {

        UsuarioMapper usuarioMapper = new UsuarioMapper();
        Usuario usuario = usuarioMapper.setUsuarioRequest(new Usuario("pepe","tester"));

        given(requestSpecification)
                .when()
                .body(usuario)
                .post("users")
                .then();
    }


    @Test
    public void actualizarUsuarioTest() {

        UsuarioMapper usuarioMapper = new UsuarioMapper();
        Usuario usuario = usuarioMapper.setUsuarioRequest(new Usuario("ana","dev"));

        given(requestSpecification)
                .body(usuario)
                .put("users/1")
                .then();
    }

}
