package com.prueba.pruebatecnica.web;

import com.prueba.pruebatecnica.configuration.builder.ResponseBuilder;
import com.prueba.pruebatecnica.model.dto.RolDTO;
import com.prueba.pruebatecnica.response.BodyRolResponse;
import com.prueba.pruebatecnica.service.IRolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/rol")
@CrossOrigin(origins = "*", methods = {
        RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET
})
public class RolControllerImpl implements IRolController{
    private static final Logger log = LoggerFactory.getLogger(RolControllerImpl.class);
    private final IRolService rolService;

    @Autowired
    public RolControllerImpl(IRolService rolService) {
        this.rolService = rolService;
    }


    @Override
    @GetMapping("/consultarRoles")
    public ResponseEntity<RolDTO> consultarRoles(HttpServletRequest request) {
        ResponseBuilder response = ResponseBuilder.newBuilder();
        try {
            BodyRolResponse rolResponse= this.rolService.consultarRoles();
            response.withStatus(HttpStatus.OK)
                    .withBusinessStatus(String.valueOf(HttpStatus.OK.value()))
                    .withResponse(rolResponse);
        } catch (Exception e) {
            log.error(e.getMessage());
            response.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus("1000")
                    .withResponse(e.getMessage());
        } finally {
        return  response.withPath(request.getRequestURI())
                .buildResponse();
        }
    }
}
