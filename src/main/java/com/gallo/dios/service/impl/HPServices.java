package com.gallo.dios.service.impl;

import com.gallo.dios.client.HPClient;
import com.gallo.dios.model.ResponseGallos;
import com.gallo.dios.model.ServiceInformation;
import com.gallo.dios.service.IHPServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class HPServices implements IHPServices {

    @Autowired
    private HPClient hpClient;
    // Definir el formato deseado
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private Logger log = LoggerFactory.getLogger(HPServices.class);
    @Override
    public ResponseGallos estatusGeneralServicios() {
        ResponseGallos responseGallos = new ResponseGallos();
        List<ServiceInformation> servicesList = new ArrayList<>();
        responseGallos.setTimestamp(LocalDateTime.now().format(formatter));

        //Servicio que obtiene todos los personajes
        servicesList.add(todosPersonajes());

        //Servicio que obtiene informacion de un Id
        servicesList.add(unPersonaje());

        responseGallos.setServices(servicesList);
        return responseGallos;
    }

    public ServiceInformation todosPersonajes(){
        ServiceInformation infoService = new ServiceInformation();
        infoService.setName("Todos los personajes");
        try {
         ResponseEntity<String> todosResponse = hpClient.allCharacters();
         log.debug("Respuesta character by id {}", todosResponse.getBody());
         infoService.setStatus(todosResponse.getStatusCode().value());
         if(infoService.getStatus()== 200){
             infoService.setActive(true);
         }else{
           infoService.setActive(false);
         }
        }catch (Exception e){
            infoService.setStatus(null);
            infoService.setActive(false);
        }
        return infoService;
    }

    public ServiceInformation unPersonaje(){

        ServiceInformation infoService = new ServiceInformation();
        infoService.setName("Personaje por Id");
        try {
            ResponseEntity<String> todosResponse = hpClient.characterById(":id");
            infoService.setStatus(todosResponse.getStatusCode().value());
            if(infoService.getStatus()== 200){
                infoService.setActive(true);
            }else{
                infoService.setActive(false);
            }
        }catch (Exception e){
            infoService.setStatus(null);
            infoService.setActive(false);
        }
        return infoService;
    }
}
