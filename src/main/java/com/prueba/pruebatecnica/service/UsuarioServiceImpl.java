package com.prueba.pruebatecnica.service;

import com.prueba.pruebatecnica.model.dto.UsuarioDTO;
import com.prueba.pruebatecnica.model.entity.UsuarioDAO;
import com.prueba.pruebatecnica.repository.IUsuarioRepositoryFacade;
import com.prueba.pruebatecnica.request.BodyUsuarioRequest;
import com.prueba.pruebatecnica.response.BodyUsuarioResponse;
import com.prueba.pruebatecnica.response.BodyUsuariosResponse;
import com.prueba.pruebatecnica.utils.PredicateUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private ModelMapper modelMapper;

    private IUsuarioRepositoryFacade usuarioRepositoryFacade;

    @Autowired
    public UsuarioServiceImpl(ModelMapper modelMapper, IUsuarioRepositoryFacade usuarioRepositoryFacade) {
        this.modelMapper = modelMapper;
        this.usuarioRepositoryFacade = usuarioRepositoryFacade;
    }

    @Override
    public boolean crearUsuario(BodyUsuarioRequest usuarioRequest) {
        UsuarioDAO usuario = new UsuarioDAO();
        boolean guardado = false;

        try {
            PredicateUtil.convertUsuarioRequest(usuarioRequest, usuario, this.modelMapper);
            log.info("El mapeo ha sido exitoso");
            guardado = this.usuarioRepositoryFacade.crearUsuario(usuario);
            if (guardado) {
                log.info("Guardado correctamente");
            } else {
                log.error("Error al guardar el usuario en el servicio");
            }
        } catch (Exception e) {
            log.error("Error al mapear el usuario del request " + e.getMessage());
            e.printStackTrace();
            return guardado;
        }

        return guardado;
    }

    @Override
    public BodyUsuariosResponse consultarUsuarios() {
        BodyUsuariosResponse usuarioResponse = new BodyUsuariosResponse();
        List<UsuarioDTO> usuarios = new ArrayList<>();

        try {
            this.usuarioRepositoryFacade.consultarUsuarios().forEach(usuario -> {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                PredicateUtil.convertUsuarioReponse(usuarioDTO, usuario, this.modelMapper);
                usuarios.add(usuarioDTO);
            });
            log.info("Lista mapeada correctamente");
            usuarioResponse.setUsuarios(usuarios);
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            e.getMessage();
        }

        return usuarioResponse;
    }

    @Override
    public BodyUsuarioResponse consultarUsuarioPorId(Long idUsuario) {
        BodyUsuarioResponse usuarioReponse = new BodyUsuarioResponse();
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        try {
            UsuarioDAO usuario = this.usuarioRepositoryFacade.buscarUsuarioPorId(idUsuario);

            if (usuario != null) {
                PredicateUtil.convertUsuarioReponse(usuarioDTO,
                        usuario,
                        this.modelMapper);
                log.info("El mapeo de usuario a usuarioDTO ha sido exitoso");
                usuarioReponse.setUsuario(usuarioDTO);
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            e.printStackTrace();
        }

        return usuarioReponse;
    }

    @Override
    public boolean actualizarUsuario(BodyUsuarioRequest usuarioRequest) {
        UsuarioDAO usuario = new UsuarioDAO();
        boolean actualizar = false;

        try {
            PredicateUtil.convertUsuarioRequest(usuarioRequest, usuario, this.modelMapper);
            log.info("El mapeo ha sido exitoso");
            actualizar = this.usuarioRepositoryFacade.actualizarUsuario(usuario);
            if (actualizar) {
                log.info("Actualizado correctamente");
            } else {
                log.error("Error al actualizar el cinema en el servicio");
            }
        } catch (Exception e) {
            log.error("Error al mapear el usuario del request " + e.getMessage());
            e.printStackTrace();
            return actualizar;
        }

        return actualizar;
    }

    @Override
    public BodyUsuarioResponse deleteUsuario(Long idUsuario) {
        BodyUsuarioResponse usuarioReponse = new BodyUsuarioResponse();
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        try {
            UsuarioDAO usuario = this.usuarioRepositoryFacade.buscarUsuarioPorId(idUsuario);

            if (usuario != null) {
                PredicateUtil.convertUsuarioReponse(usuarioDTO,
                        usuario,
                        this.modelMapper);
                log.info("El mapeo de usuario a usuarioDTO ha sido exitoso");
                //usuarioReponse.setUsuario(usuarioDTO);
                this.usuarioRepositoryFacade.eliminarUsuario(usuario);
            } else {
                log.error("Error al elimnar el usuario en el servicio");
                return null;
            }

        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            e.printStackTrace();
        }

        return usuarioReponse;
    }

}



