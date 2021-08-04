package com.prueba.pruebatecnica.response;

import com.prueba.pruebatecnica.model.dto.RolDTO;
import lombok.Data;

import java.util.List;

@Data
public class BodyRolResponse {

    private List<RolDTO> roles;

}
