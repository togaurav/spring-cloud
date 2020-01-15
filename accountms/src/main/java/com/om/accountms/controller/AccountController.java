package com.om.accountms.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/account/")
@Validated
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final Environment env;
    Map<String, Map<String, String>> accounts = new HashMap<>();

    {
        Map<String, String> m1 = new HashMap<>();
        m1.put("mobile", "123");
        m1.put("account", "sbi");
        accounts.put("1", m1);

        Map<String, String> m2 = new HashMap<>();
        m2.put("mobile", "456");
        m2.put("account", "hdfc");
        accounts.put("2", m2);
    }

    @GetMapping(value = "/status", produces = {MediaType.ALL_VALUE})
    public String status() {
        return "Account ms is working ";
    }

    @GetMapping(value = "{id}", produces = {MediaType.ALL_VALUE})
    public ResponseEntity<Object> get(@NotNull @PathVariable String id) {
        Map<String, String> orDefault = accounts.getOrDefault(id, new HashMap<>());
        orDefault.put("port", env.getProperty("local.server.port"));
        return ResponseEntity.ok(orDefault);
    }
}
