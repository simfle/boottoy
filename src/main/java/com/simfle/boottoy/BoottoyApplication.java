package com.simfle.boottoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;


@EnableJpaRepositories
@SpringBootApplication
public class BoottoyApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoottoyApplication.class, args);
    }
}
