package com.louazri.webapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.louazri.webapplication.repository")
@EntityScan(basePackages = "com.louazri.webapplication.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
