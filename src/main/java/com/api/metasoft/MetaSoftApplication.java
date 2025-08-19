package com.api.metasoft;

import org.springframework.boot.autoconfigure.domain.EntityScan; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { 
    "com.metasoft.thymeleaf", 
    "com.metasoft.controller", 
    "com.api.metasoft.config",
    "com.api.metasoft.service",
    "com.api.metasoft.repository",
    "com.api.metasoft"
})
@EnableJpaRepositories("com.api.metasoft.repository")
@EntityScan("com.metasoft.thymeleaf") 

public class MetaSoftApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetaSoftApplication.class, args);
    }
}
