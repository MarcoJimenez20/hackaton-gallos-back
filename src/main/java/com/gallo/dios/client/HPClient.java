package com.gallo.dios.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "hp-service", url = "${feign.client.hp-service.url}")
public interface HPClient {

    @GetMapping("/characters")
    JsonNode allCharacters();

}
