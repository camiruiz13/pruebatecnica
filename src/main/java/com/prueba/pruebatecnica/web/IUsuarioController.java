package com.prueba.pruebatecnica.web;

import com.prueba.pruebatecnica.model.dto.UsuarioDTO;
import com.prueba.pruebatecnica.request.BodyUsuarioRequest;
import org.springframework.http.ResponseEntity;


import javax.servlet.http.HttpServletRequest;

public interface IUsuarioController {

    ResponseEntity<UsuarioDTO> crearUsuarios(BodyUsuarioRequest usuarioRequest, HttpServletRequest request);

    ResponseEntity<UsuarioDTO> consultarUsuarios(HttpServletRequest request);

    ResponseEntity<UsuarioDTO> consultarUsuarioById(Long idUsuario, HttpServletRequest request);

    ResponseEntity<UsuarioDTO> actualizarUsuario(BodyUsuarioRequest usuarioRequest, HttpServletRequest request);

    ResponseEntity<UsuarioDTO> eliminarUsuario(Long idUsuario, HttpServletRequest request);

}
