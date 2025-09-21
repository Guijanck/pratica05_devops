package br.com.valueprojects.teste_unidade_2.Test;

import br.com.valueprojects.teste_unidade_2.builder.CriadorDeJogo;
import br.com.valueprojects.teste_unidade_2.dominio.Jogo;
import br.com.valueprojects.teste_unidade_2.dominio.Participante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CriadorDeJogoTest {

    @Test
    public void deveConstruirJogoComResultados() {
        // Cenário
        Participante p1 = new Participante("Joao");
        Participante p2 = new Participante("Maria");

        // Ação
        Jogo jogo = new CriadorDeJogo()
            .para("Campeonato de Xadrez")
            .resultado(p1, 100.0)
            .resultado(p2, 150.0)
            .constroi();

        // Verificação
        assertEquals("Campeonato de Xadrez", jogo.getDescricao());
        assertEquals(2, jogo.getResultados().size());
        assertEquals(100.0, jogo.getResultados().get(0).getMetrica());
        assertEquals(150.0, jogo.getResultados().get(1).getMetrica());
    }
}