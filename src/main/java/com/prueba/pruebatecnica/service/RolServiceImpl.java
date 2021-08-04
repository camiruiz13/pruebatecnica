package com.prueba.pruebatecnica.service;

import com.prueba.pruebatecnica.model.dto.RolDTO;
import com.prueba.pruebatecnica.repository.IRolRepositoryFacade;
import com.prueba.pruebatecnica.response.BodyRolResponse;
import com.prueba.pruebatecnica.utils.PredicateUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RolServiceImpl implements IRolService {

    private ModelMapper modelMapper;
    private IRolRepositoryFacade rolRepositoryFacade;

    @Autowired
    public RolServiceImpl(ModelMapper modelMapper, IRolRepositoryFacade rolRepositoryFacade) {
        this.modelMapper = modelMapper;
        this.rolRepositoryFacade = rolRepositoryFacade;
    }

    @Override
    public BodyRolResponse consultarRoles() {

        BodyRolResponse rolResponse= new BodyRolResponse();
        List<RolDTO> roles= new ArrayList<>();
    try {
        this.rolRepositoryFacade.darRoles().forEach(rol -> {
            RolDTO rolDTO = new RolDTO();
            PredicateUtil.convertRolReponse(rolDTO, rol, this.modelMapper);
            roles.add(rolDTO);
        });
        log.info("Lista mapeada correctamente");
        rolResponse.setRoles(roles);
    }catch (Exception e){
        log.error("Error " + e.getMessage());
        e.getMessage();
    }
        return rolResponse;
    }
}
