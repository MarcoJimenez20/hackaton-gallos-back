package com.gallo.dios.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gallo.dios.client.HPClient;
import com.gallo.dios.service.IHPServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HPServices implements IHPServices {

    @Autowired
    private HPClient hpClient;


    @Override
    public JsonNode todosPersonajes() {
        return hpClient.allCharacters();
    }
}
