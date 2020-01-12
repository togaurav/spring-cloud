package com.om.userms.controller;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@NoArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/users/")
public class UserController {

    @GetMapping(path = "/{userId}", produces = {MediaType.ALL_VALUE})
    public ResponseEntity<Object> get(String userId) {
        Map<String, String> user = new HashMap<>();
        user.put("name", "gaurav");
        user.put("mobile","8867846411");
        return ResponseEntity.ok(user);
    }
}
