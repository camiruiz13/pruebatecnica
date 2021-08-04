package com.prueba.pruebatecnica.web;

import com.prueba.pruebatecnica.configuration.WebClientException;
import com.prueba.pruebatecnica.configuration.builder.ResponseBuilder;
import com.prueba.pruebatecnica.model.dto.UsuarioDTO;
import com.prueba.pruebatecnica.request.BodyUsuarioRequest;
import com.prueba.pruebatecnica.response.BodyUsuarioResponse;
import com.prueba.pruebatecnica.response.BodyUsuariosResponse;
import com.prueba.pruebatecnica.service.IUsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping(path = "usuario")
@CrossOrigin(origins = "*", methods = {
        RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET
})
public class IUsuarioControllerImpl implements IUsuarioController {

    private  final IUsuarioService usuarioService;

    @Autowired
    public IUsuarioControllerImpl(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    @PostMapping("/registrarusuario")
    public ResponseEntity<UsuarioDTO> crearUsuarios(@RequestBody BodyUsuarioRequest usuarioRequest,
                                                    HttpServletRequest request) {
        ResponseBuilder response = ResponseBuilder.newBuilder();

        try {
            boolean usuarioResponse = this.usuarioService.crearUsuario(usuarioRequest);
            response.withStatus(HttpStatus.OK)
                    .withBusinessStatus(String.valueOf(HttpStatus.OK.value()))
                    .withResponse(usuarioResponse);
        } catch (WebClientException e) {
            log.error(e.getMessage());
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(e.getCode())
                    .withResponse(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus("1000")
                    .withResponse(e.getMessage());
        } finally {
            return response.withPath(request.getRequestURI())
                    .buildResponse();
        }
    }

    @Override
    @GetMapping("/consultarUsuarios")
    public ResponseEntity<UsuarioDTO> consultarUsuarios(HttpServletRequest request) {
        ResponseBuilder response = ResponseBuilder.newBuilder();

        try {
            BodyUsuariosResponse usuarioResponse = this.usuarioService.consultarUsuarios();
            response.withStatus(HttpStatus.OK)
                    .withBusinessStatus(String.valueOf(HttpStatus.OK.value()))
                    .withResponse(usuarioResponse);
        } catch (WebClientException e) {
            log.error(e.getMessage());
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(e.getCode())
                    .withResponse(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus("1000")
                    .withResponse(e.getMessage());
        } finally {
            return response.withPath(request.getRequestURI())
                    .buildResponse();
        }
    }

    @Override
    @GetMapping("/consultarUsuarioPorId/{idUsuario}")
    public ResponseEntity<UsuarioDTO> consultarUsuarioById(@PathVariable("idUsuario") Long idUsuario, HttpServletRequest request) {
        ResponseBuilder response = ResponseBuilder.newBuilder();

        try {
            BodyUsuarioResponse usuariosResponse = this.usuarioService.consultarUsuarioPorId(idUsuario);
            response.withStatus(HttpStatus.OK)
                    .withBusinessStatus(String.valueOf(HttpStatus.OK.value()))
                    .withResponse(usuariosResponse);
        } catch (WebClientException e) {
            log.error(e.getMessage());
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(e.getCode())
                    .withResponse(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus("1000")
                    .withResponse(e.getMessage());
        } finally {
            return response.withPath(request.getRequestURI())
                    .buildResponse();
        }
    }

    @Override
    @PutMapping("/actualizarUsuario")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody BodyUsuarioRequest usuarioRequest, HttpServletRequest request) {
        ResponseBuilder response = ResponseBuilder.newBuilder();

        try {
            boolean usuarioResponse =this.usuarioService.actualizarUsuario(usuarioRequest);
            response.withStatus(HttpStatus.OK)
                    .withBusinessStatus(String.valueOf(HttpStatus.OK.value()))
                    .withResponse(usuarioResponse);
        } catch (WebClientException e) {
            log.error(e.getMessage());
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(e.getCode())
                    .withResponse(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus("1000")
                    .withResponse(e.getMessage());
        } finally {
            return response.withPath(request.getRequestURI())
                    .buildResponse();
        }
    }

    @Override
    @DeleteMapping("/eliminarUsuario/{idUsuario}")
    public ResponseEntity<UsuarioDTO> eliminarUsuario(@PathVariable("idUsuario") Long idUsuario, HttpServletRequest request) {
        ResponseBuilder response = ResponseBuilder.newBuilder();

        try {
            BodyUsuarioResponse usuariosResponse = this.usuarioService.deleteUsuario(idUsuario);
            response.withStatus(HttpStatus.OK)
                    .withBusinessStatus(String.valueOf(HttpStatus.OK.value()))
                    .withResponse(usuariosResponse);
        } catch (WebClientException e) {
            log.error(e.getMessage());
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(e.getCode())
                    .withResponse(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus("1000")
                    .withResponse(e.getMessage());
        } finally {
            return response.withPath(request.getRequestURI())
                    .buildResponse();
        }

    }


}



