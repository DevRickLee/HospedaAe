package br.com.devlee.hospedaae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HospedaAeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospedaAeApplication.class, args);
	}

	@GetMapping("/")
	public String inicio(){
		String msg = "Seja-Bem vindo ao HospedaAe";
		return msg;
	}
}
