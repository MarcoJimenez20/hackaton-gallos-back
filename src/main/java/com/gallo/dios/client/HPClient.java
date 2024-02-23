package com.gallo.dios.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hp-service", url = "${feign.client.hp-service.url}")
public interface HPClient {

    @GetMapping("/characters")
    ResponseEntity<String> allCharacters();

    @GetMapping("/character/{id}")
    ResponseEntity<String> characterById(@PathVariable String id);
}
