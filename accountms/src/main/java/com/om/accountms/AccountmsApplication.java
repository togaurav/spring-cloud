package com.om.accountms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountmsApplication.class, args);
    }

}
