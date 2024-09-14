package br.edu.ifba.busca;

import br.edu.ifba.busca.numeros.Numeros;
import br.edu.ifba.busca.impl.BuscadorImpl;
import br.edu.ifba.busca.impl.CasosImpl;
import br.edu.ifba.busca.impl.NumerosImpl;
import br.edu.ifba.busca.buscadores.Buscador;
import br.edu.ifba.busca.buscadores.ResultadoBusca;
import br.edu.ifba.busca.casos.Casos;
import br.edu.ifba.busca.impl.CasosImpl;


public class App {
    private static final int TOTAL_NUMEROS = 100;
    private static final int NUMERO_PROCURADO = 30;

    public static void main(String[] args) throws Exception {
       Numeros numeros = new NumerosImpl();
       Buscador buscador = new BuscadorImpl();
       Casos casos = new CasosImpl(TOTAL_NUMEROS/4);
       
       ResultadoBusca resultado = buscador.buscar(NUMERO_PROCURADO, numeros.gerar(TOTAL_NUMEROS));

       casos.setResultadoBusca(resultado);
       if(casos.detectarMelhorCaso()){
            System.out.println("Melhor caso detectado, posição:"+ resultado.getPassosExecutados());
       }else if(casos.detectarCasoMedio()){
            System.out.println("Caso médio detectado, posição:"+ resultado.getPassosExecutados());
       } else if(casos.detectarPiorCaso()){
            System.out.println("Pior caso detectado");
       }

    }
}
