package com.gallo.dios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstatusHPServicios {

    @RequestMapping("/estatus/servicios")
    public ResponseEntity<?> executeStatusServices(){
        return ResponseEntity.ok("Hola Team");
    }
}
