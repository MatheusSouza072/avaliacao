package com.publicacoes.avaliacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AvaliacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoApplication.class, args);
	}

}
