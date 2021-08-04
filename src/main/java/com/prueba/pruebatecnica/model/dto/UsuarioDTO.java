package com.prueba.pruebatecnica.model.dto;


import lombok.Data;

@Data
public class UsuarioDTO {

    private Long idUsuario;
    private RolDTO rol;
    private String nombre;
    private  String  activo;
}
