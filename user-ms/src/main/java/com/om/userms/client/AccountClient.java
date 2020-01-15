package com.om.userms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;
import java.util.Map;

@FeignClient(name = "accountms")
public interface AccountClient {
    @GetMapping(value = "/api/v1/account/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    Map<String, String> get(@PathVariable String id);
}
