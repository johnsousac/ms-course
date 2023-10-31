package com.devsuperior.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	/*
	 * registrar uma instancia unica do objeto para ser 
	 * usado no sistema inteiro, ou seja, um singleton
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
