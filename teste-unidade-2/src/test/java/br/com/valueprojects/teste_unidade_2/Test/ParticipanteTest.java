package br.com.valueprojects.teste_unidade_2.Test;

import br.com.valueprojects.teste_unidade_2.dominio.Jogo;
import br.com.valueprojects.teste_unidade_2.dominio.Participante;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ParticipanteTest {
	
	 @Test
	    void deveRetornarTrueParaObjetosIguais() {
	        Participante p1 = new Participante(1, "Ana");
	        Participante p2 = new Participante(1, "Ana");
	        assertEquals(p1, p2);
	    }
	    
	    @Test
	    void deveRetornarFalseSeObjetoForNulo() {
	        Participante p1 = new Participante(1, "Ana");
	        assertNotEquals(p1, null);
	    }

	    @Test
	    void deveRetornarFalseSeObjetoForDeClasseDiferente() {
	        Participante p1 = new Participante(1, "Ana");
	        assertNotEquals(p1, new String("Ana"));
	    }

	    @Test
	    void deveRetornarFalseSeIdsForemDiferentes() {
	        Participante p1 = new Participante(1, "Ana");
	        Participante p2 = new Participante(2, "Ana");
	        
	        assertEquals(1, p1.getId()); 
	        assertEquals(2, p2.getId());
	        
	        assertNotEquals(p1, p2);
	    }

	    @Test
	    void deveRetornarFalseSeNomesForemDiferentes() {
	        Participante p1 = new Participante(1, "Ana");
	        Participante p2 = new Participante(1, "Joao");
	        assertNotEquals(p1, p2);
	    }

	    @Test
	    void deveRetornarFalseSeUmNomeForNuloEOutroNao() {
	        Participante p1 = new Participante(1, null);
	        Participante p2 = new Participante(1, "Joao");
	        assertNotEquals(p1, p2);
	    }
	    
	    @Test
	    void deveRetornarTrueSeAmbosOsNomesForemNulos() {
	        Participante p1 = new Participante(1, null);
	        Participante p2 = new Participante(1, null);
	        assertEquals(p1, p2);
	    }
	    
	    @Test
	    void deveRespeitarSimetria() {
	        // Arrange
	        Participante p1 = new Participante(1, "Ana");
	        Participante p2 = new Participante(1, "Ana");

	        // Act
	        boolean p1EqualsP2 = p1.equals(p2);
	        boolean p2EqualsP1 = p2.equals(p1);

	        // Assert
	        assertTrue(p1EqualsP2);
	        assertTrue(p2EqualsP1);
	    }

}
