package br.com.valueprojects.teste_unidade_2.dominio;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {
	private String descricao;
	private List<Resultado> resultados;
	
	public Jogo(String descricao) {
		this.descricao = descricao;
		this.resultados = new ArrayList<Resultado>();
	}
	
	public void anota(Resultado resultado) {
		if(resultados.isEmpty() || 
                !resultados.get(ultimoResultadoVisto()).getParticipante().equals(resultado.getParticipante())) {
            resultados.add(resultado);
        }
		
	}

	private int ultimoResultadoVisto() {
		return resultados.size()-1;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Resultado> getResultados() {
		return Collections.unmodifiableList(resultados);
	}

			
	
	

	//Green - TDD - Ainda falhando - Isso gera 500/2 + 500/2 = 250 + 250 = 250 
	//(porque a cada iteração você já divide pela quantidade de elementos).
   // Certo: somar todas as notas primeiro e só depois dividir:
	/*public double calculaMedia() {
		double pontuacaoMembroUm = 0.0;
		double pontuacaoMembroDois = 0.0;
		
	    for (Resultado resultado : resultados) {
	        if (resultado.getParticipante().getNome().equals("Membro Um")) {
	            pontuacaoMembroUm = resultado.getMetrica();
	        }
	        if (resultado.getParticipante().getNome().equals("Membro Dois Costa")) {
	            pontuacaoMembroDois = resultado.getMetrica();
	        }
	    }
		return (pontuacaoMembroUm + pontuacaoMembroDois) / 2;
}*/

	//Green - TDD            
	/*public double calculaMedia() {
	                if (resultados == null || resultados.isEmpty()) return 0.0;

	                double soma = 0.0;
	                int n = 0;
	                for (Resultado r : resultados) {
	                    soma += r.getMetrica(); // ou getNota()
	                    n++;
	                }
	                return soma / n;
		           }*/
	
	
	//Blue - Refactor (option 1)
	/*public double calculaMedia() {
	    if (resultados.isEmpty()) return 0.0;

	    double soma = 0.0;
	    for (Resultado r : resultados) {
	        soma += r.getMetrica(); // ou getNota()
	    }
	    return soma / resultados.size();
	}
*/
	
	//Blue - Refactor (option 2)
	
	/*public double calculaMedia() {
	    return resultados.stream()
	            .mapToDouble(Resultado::getMetrica) // ou getNota()
	            .average()
	            .orElse(0.0);
	}*/
}
