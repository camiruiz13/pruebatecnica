package com.prueba.pruebatecnica.web;

import com.prueba.pruebatecnica.model.dto.RolDTO;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface IRolController {
    ResponseEntity<RolDTO> consultarRoles(HttpServletRequest request);
}
