package com.gallo.dios.controller;

import com.gallo.dios.service.IHPServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstatusHPServicios {

    @Autowired
    private IHPServices ihpServices;

    @RequestMapping("/estatus/servicios")
    public ResponseEntity<?> executeStatusServices(){
        return ResponseEntity.ok(ihpServices.todosPersonajes());
    }
}
