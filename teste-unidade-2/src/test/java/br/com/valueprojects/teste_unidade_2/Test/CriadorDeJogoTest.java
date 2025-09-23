package br.com.valueprojects.teste_unidade_2.Test;

import br.com.valueprojects.teste_unidade_2.builder.CriadorDeJogo;
import br.com.valueprojects.teste_unidade_2.dominio.Jogo;
import br.com.valueprojects.teste_unidade_2.dominio.Participante;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CriadorDeJogoTest {
	
	@Test
	public void testCriadorDeJogoComResultado() {
	    Participante p1 = new Participante("Jogador Teste");

	    Jogo jogo = new CriadorDeJogo()
	            .para("Jogo Builder")
	            .resultado(p1, 50.0)   // <- chama o método que está vermelho
	            .constroi();

	    assertEquals("Jogo Builder", jogo.getDescricao());
	    assertEquals(1, jogo.getResultados().size());
	    assertEquals(50.0, jogo.getResultados().get(0).getMetrica());
	    assertEquals(p1, jogo.getResultados().get(0).getParticipante());
	}


}
