package com.prueba.pruebatecnica.repository;

import com.prueba.pruebatecnica.jpa.IUsuarioRepository;
import com.prueba.pruebatecnica.model.entity.UsuarioDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UsuarioRepositoryFacadeImpl implements IUsuarioRepositoryFacade {

    private IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioRepositoryFacadeImpl(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public boolean crearUsuario(UsuarioDAO usuario) {

        try {
            this.usuarioRepository.save(usuario);
            log.info("Guardado exitosamente");
        } catch (Exception e) {
            log.error("Error guardando el usuario");
            e.printStackTrace();
            return false;
        }

        return true;
    }


    @Override
    public List<UsuarioDAO> consultarUsuarios() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public UsuarioDAO buscarUsuarioPorId(Long idUsuario) {

        return this.usuarioRepository.findById(idUsuario).orElseGet(()->{
            log.error("Usuario identifica con el id " + idUsuario + ". No existe");
            return null;
        });
    }

    @Override
    public boolean actualizarUsuario(UsuarioDAO usuario) {
        try {
            this.usuarioRepository.save(usuario);
            log.info("Actualizado exitosamente");
        } catch (Exception e) {
            log.error("Error actualizado el usuario");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean eliminarUsuario(UsuarioDAO usuario) {
        try {
            this.usuarioRepository.delete(usuario);
            log.info("Actualizado exitosamente");
        } catch (Exception e) {
            log.error("Error actualizado el usuario");
            e.printStackTrace();
            return false;
        }

        return true;
    }


}
