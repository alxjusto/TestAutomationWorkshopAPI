package com.workshop.api.mapper;

import com.workshop.api.dto.Usuario;

public class UsuarioMapper {

    Usuario usuarioBodyRequest = new Usuario();

    public Usuario setUsuarioRequest(Usuario usuario) {
        usuarioBodyRequest.setName(usuario.getName());
        usuarioBodyRequest.setJob(usuario.getJob());
        return usuarioBodyRequest;
    }
}
