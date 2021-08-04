package com.prueba.pruebatecnica.response;

import com.prueba.pruebatecnica.model.dto.UsuarioDTO;
import lombok.Data;

import java.util.List;

@Data
public class BodyUsuariosResponse {
private List<UsuarioDTO> usuarios;


}
