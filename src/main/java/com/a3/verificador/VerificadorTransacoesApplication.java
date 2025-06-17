package com.a3.verificador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = "com.a3.verificador"
)
public class VerificadorTransacoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerificadorTransacoesApplication.class, args);
    }
}
