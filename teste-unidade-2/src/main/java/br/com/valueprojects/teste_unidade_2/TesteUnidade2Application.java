package br.com.valueprojects.teste_unidade_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteUnidade2Application {

	public static void main(String[] args) {
		
		// Este é o método de inicialização da aplicação e não contém lógica de negócio.
        // Portanto, não precisa ser coberto por testes de unidade.
		SpringApplication.run(TesteUnidade2Application.class, args);
	}

}
