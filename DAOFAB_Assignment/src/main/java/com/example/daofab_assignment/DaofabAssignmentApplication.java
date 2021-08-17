package com.example.daofab_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {
        "com.example.daofab_assignment.repository",
} )
public class DaofabAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaofabAssignmentApplication.class, args);
    }

}
