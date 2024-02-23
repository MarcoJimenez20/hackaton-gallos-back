package com.gallo.dios.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseGallos {

    private List<ServiceInformation> services;
    private String timestamp;


}
