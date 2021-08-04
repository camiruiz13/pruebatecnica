package com.prueba.pruebatecnica.service;

import com.prueba.pruebatecnica.request.BodyUsuarioRequest;
import com.prueba.pruebatecnica.response.BodyUsuarioResponse;
import com.prueba.pruebatecnica.response.BodyUsuariosResponse;

public interface IUsuarioService {

    boolean crearUsuario(BodyUsuarioRequest usuarioRequest);

    BodyUsuariosResponse consultarUsuarios();

    BodyUsuarioResponse consultarUsuarioPorId(Long idUsuario);

    boolean actualizarUsuario(BodyUsuarioRequest usuarioRequest);

    BodyUsuarioResponse deleteUsuario(Long idUsuario);



    //ResponseEntity<GenericResponseDTO> eliminadoLogicoPorId(Integer id);



}
