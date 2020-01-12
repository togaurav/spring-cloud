package com.om.userms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users/")
public class UserController {

    public ResponseEntity<String> get(String userId) {
        return ResponseEntity.ok("gaurav");
    }
}
