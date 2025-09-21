package br.com.valueprojects.teste_unidade_2.Test;

import br.com.valueprojects.teste_unidade_2.dominio.Participante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParticipanteTest {

    @Test
    public void testEquals() {
        Participante p1 = new Participante(1, "Joao");
        Participante p2 = new Participante(1, "Joao");
        Participante p3 = new Participante(2, "Maria");
        Participante p4 = new Participante(1, "Pedro");
        Participante pNull1 = new Participante(1, null);
        Participante pNull2 = new Participante(1, null);

        // Teste de reflexividade
        assertEquals(p1, p1);

        // Teste de simetria
        assertEquals(p1, p2);
        assertEquals(p2, p1);

        // Teste de transitividade
        Participante p5 = new Participante(1, "Joao");
        assertEquals(p1, p2);
        assertEquals(p2, p5);
        assertEquals(p1, p5);

        // Teste com nulo
        assertNotEquals(p1, null);

        // Teste com tipos diferentes
        assertNotEquals(p1, "Joao");

        // Teste com IDs diferentes
        assertNotEquals(p1, p3);
        
        // Teste com nomes diferentes
        assertNotEquals(p1, p4);
        
        // Novos testes para nomes nulos
        assertEquals(pNull1, pNull2); // this.nome == null e other.nome == null
        assertNotEquals(pNull1, p1);  // this.nome == null e other.nome != null
        assertNotEquals(p1, pNull1);  // this.nome != null e other.nome == null
    }

    @Test
    void testGettersEConstrutores() {
        Participante p1 = new Participante(1, "Jose");
        assertEquals(1, p1.getId());
        assertEquals("Jose", p1.getNome());

        Participante p2 = new Participante("Maria");
        assertEquals(0, p2.getId());
        assertEquals("Maria", p2.getNome());
    }
}