package br.com.valueprojects.teste_unidade_2.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.valueprojects.teste_unidade_2.builder.CriadorDeJogo;
import br.com.valueprojects.teste_unidade_2.dominio.Jogo;
import br.com.valueprojects.teste_unidade_2.dominio.Juiz;
import br.com.valueprojects.teste_unidade_2.dominio.Participante;
import br.com.valueprojects.teste_unidade_2.dominio.Resultado;

import static org.junit.jupiter.api.Assertions.*;

public class JulgamentoTest {

    private Juiz juiz;
    private Participante joao;
    private Participante pedro;
    private Participante katia;
    private Participante maria;

    @BeforeEach
    void criaJuiz() {
        this.juiz  = new Juiz();
        this.joao  = new Participante("Joao");
        this.pedro = new Participante("Pedro");
        this.katia = new Participante("Katia");
        this.maria = new Participante("Maria");
    }

    @Test
    void deveJulgarPrimeiroEultimoColocado() {
        Jogo jogo = new Jogo("Derruba barreiras");

        jogo.anota(new Resultado(joao, 90.0));
        jogo.anota(new Resultado(pedro, 91.0));
        jogo.anota(new Resultado(katia, 93.0));
        jogo.anota(new Resultado(maria, 94.0));

        juiz.julga(jogo);

        double vencedorJogo = 94.0;
        double ultimoColocadoJogo = 90.0;

        assertEquals(vencedorJogo, juiz.getPrimeiroColocado(), 1e-5);
        assertEquals(ultimoColocadoJogo, juiz.getUltimoColocado(), 1e-5);
    }

    @Test
    void naoDeveJulgarSemResultado() {
        Jogo jogo = new CriadorDeJogo()
            .para("Caca pecas")
            .constroi(); // sem resultados

        assertThrows(RuntimeException.class, () -> juiz.julga(jogo));
    }

    
    @Test
    public void deveEncontrarOMaiorEMenorPontuacao() {
        // 1. Cenário
        Jogo jogo = new Jogo("Jogo de Pontos");
        
        // Crie participantes e resultados
        Participante participante1 = new Participante("João");
        Participante participante2 = new Participante("Maria");
        
        // Anote os resultados no objeto Jogo
        jogo.anota(new Resultado(participante1, 10.0));
        jogo.anota(new Resultado(participante2, 20.0)); 
        
        // 2. Ação
        // Chame o método julga com o objeto Jogo
        juiz.julga(jogo);

        // 3. Verificação
        assertEquals(20.0, juiz.getPrimeiroColocado(), 0.001);
        assertEquals(10.0, juiz.getUltimoColocado(), 0.001);
    }
   
}

