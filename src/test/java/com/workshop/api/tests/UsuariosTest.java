package com.workshop.api.tests;

import com.workshop.api.dto.User;
import com.workshop.api.helper.BaseTestHelper;
import com.workshop.api.helper.CreateUserHelper;
import com.workshop.api.mapper.UsuarioMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UsuariosTest extends BaseTestHelper {

    @Test
    public void obtenerListadoDeUsuarioTest() {
        given()
                .get("users?page=1")
                .then();
    }

    @Test
    public void crearUsuarioTest() throws Exception {
        CreateUserHelper createUserHelper = new CreateUserHelper();
        Response response = createUserHelper.createUser();
        Assertions.assertEquals(201, response.getStatusCode());
    }

    @Test
    public void actualizarUsuarioTest() {

        UsuarioMapper usuarioMapper = new UsuarioMapper();
        User user = usuarioMapper.setUsuarioRequest(new User("ana", "dev"));

        given()
                .body(user)
                .put("users/1")
                .then();
    }

}
