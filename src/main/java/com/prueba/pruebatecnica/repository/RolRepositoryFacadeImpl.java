package com.prueba.pruebatecnica.repository;

import com.prueba.pruebatecnica.jpa.IRolRepository;
import com.prueba.pruebatecnica.model.entity.RolDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class RolRepositoryFacadeImpl implements IRolRepositoryFacade{



    private IRolRepository rolRepository;

    @Autowired
    public RolRepositoryFacadeImpl(IRolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }


    @Override
    public List<RolDAO> darRoles() {
        return this.rolRepository.findAll();
    }
}
