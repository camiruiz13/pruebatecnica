package com.prueba.pruebatecnica.utils;

import com.prueba.pruebatecnica.model.dto.RolDTO;
import com.prueba.pruebatecnica.model.dto.UsuarioDTO;
import com.prueba.pruebatecnica.model.entity.RolDAO;
import com.prueba.pruebatecnica.model.entity.UsuarioDAO;
import com.prueba.pruebatecnica.request.BodyUsuarioRequest;
import org.modelmapper.ModelMapper;

public class PredicateUtil {

    public static void convertRolReponse(
            RolDTO rolDTO, RolDAO rolDAO,
            ModelMapper modelMapper){
        modelMapper.map(rolDAO, rolDTO);
    }

    public static void convertUsuarioRequest(BodyUsuarioRequest usuarioRequest,
                                             UsuarioDAO usuario,
                                             ModelMapper modelMapper) {

                                             modelMapper.map(usuarioRequest.getUsuario(), usuario);
    }

    public static void convertUsuarioReponse(UsuarioDTO usuarioDTO,
                                             UsuarioDAO usuario,
                                             ModelMapper modelMapper) {
        modelMapper.map(usuario, usuarioDTO);
    }
}
