package br.com.valueprojects.teste_unidade_2.Test;

import br.com.valueprojects.teste_unidade_2.dominio.Jogo;
import br.com.valueprojects.teste_unidade_2.dominio.Resultado;
import br.com.valueprojects.teste_unidade_2.dominio.Participante;
import br.com.valueprojects.teste_unidade_2.dominio.Juiz; // se existir
import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JogoTest {

    @Test
    public void testAnotaResultados() {
        // Cria o jogo com a descrição
        Jogo jogo = new Jogo("Partida de Teste");

        // Cria participantes
        Participante p1 = new Participante("Membro Um");
        Participante p2 = new Participante("Membro Dois");

        // Cria resultados com participante e métrica
        Resultado r1 = new Resultado(p1, 10.0);
        Resultado r2 = new Resultado(p2, 20.0);

        // Anota resultados no jogo
        jogo.anota(r1);
        jogo.anota(r2);

        // Verifica que os resultados foram adicionados
        List<Resultado> resultados = jogo.getResultados();
        assertEquals(2, resultados.size());
        assertEquals(10.0, resultados.get(0).getMetrica());
        assertEquals(20.0, resultados.get(1).getMetrica());
    }

    @Test
    public void testCalculaMedia() {
        Jogo jogo = new Jogo("Partida de Teste");

        Participante p1 = new Participante("Membro Um");
        Participante p2 = new Participante("Membro Dois");

        jogo.anota(new Resultado(p1, 10.0));
        jogo.anota(new Resultado(p2, 20.0));

        // Calcula média
        double media = jogo.calculaMedia();
        assertEquals(15.0, media);
    }
    
    @Test
    public void testCalculaMediaSemResultados() {
        Jogo jogo = new Jogo("Partida vazia");
        assertEquals(0.0, jogo.calculaMedia()); 
        // ou assertThrows, se o código lançar exceção
    }
    
    @Test
    public void testNaoAdicionaMesmoParticipanteDuasVezesSeguidas() {
        Jogo jogo = new Jogo("Partida duplicada");

        Participante p1 = new Participante("Membro Um");

        // Primeiro resultado - deve ser adicionado
        jogo.anota(new Resultado(p1, 10.0));
        // Segundo resultado com o mesmo participante - não deve ser adicionado
        jogo.anota(new Resultado(p1, 20.0));

        // Só o primeiro resultado deve estar na lista
        assertEquals(1, jogo.getResultados().size());
        assertEquals(10.0, jogo.getResultados().get(0).getMetrica());
    }
}