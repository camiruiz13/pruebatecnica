package com.prueba.pruebatecnica.repository;

import com.prueba.pruebatecnica.model.entity.UsuarioDAO;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepositoryFacade {

    boolean crearUsuario(UsuarioDAO usuario);

    List<UsuarioDAO> consultarUsuarios();

    UsuarioDAO buscarUsuarioPorId(Long idUsuario);

    boolean actualizarUsuario(UsuarioDAO usuario);

    boolean eliminarUsuario(UsuarioDAO usuario);

}
