package com.om.userms.controller;

import com.om.userms.client.AccountClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/users/")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final Environment env;
    private final AccountClient accountClient;
    private Map<String, Map<String, String>> users = new HashMap<>();

    @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> get(@NotNull @PathVariable String id) {
        log.info("Port : {}", env.getProperty("local.server.port"));
        Map<String, String> user = users.getOrDefault(id, new HashMap<>());

        try{
            user.put("account", accountClient.get(id).toString());
        } catch (Exception e) {
            log.error("Error in accessing account info", e);
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping(produces = {MediaType.ALL_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> save(@NotNull @RequestBody Map<String, String> responseBody) {
        log.info(responseBody.toString());
        responseBody.put("port", env.getProperty("local.server.port"));
        users.put(responseBody.get("id"), responseBody);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity delete(@NotNull @PathVariable String id) {
        users.remove(id);
        return ResponseEntity.noContent().build();
    }
}
