package br.edu.ifba.busca;

import br.edu.ifba.busca.numeros.Numeros;
import br.edu.ifba.busca.impl.BuscadorBinarioImpl;
import br.edu.ifba.busca.impl.BuscadorImpl;
import br.edu.ifba.busca.impl.CasosBuscaBinariaImpl;
import br.edu.ifba.busca.impl.CasosImpl;
import br.edu.ifba.busca.impl.NumerosImpl;
import br.edu.ifba.busca.buscadores.Buscador;
import br.edu.ifba.busca.buscadores.ResultadoBusca;
import br.edu.ifba.busca.casos.Casos;
import br.edu.ifba.busca.impl.CasosImpl;

import br.edu.ifba.busca.impl.BuscadorBinarioImpl;

public class App {
    private static final int TOTAL_NUMEROS = 100;
    private static final int NUMERO_PROCURADO = 1;

    public static void main(String[] args) throws Exception {
       Numeros numeros = new NumerosImpl();
       Buscador buscador = new BuscadorBinarioImpl();
       Casos casos = new CasosBuscaBinariaImpl(TOTAL_NUMEROS/3);
       
       ResultadoBusca resultado = buscador.buscar(NUMERO_PROCURADO, numeros.gerar(TOTAL_NUMEROS,false));

       casos.setResultadoBusca(resultado);
       if(casos.detectarMelhorCaso()){
            System.out.println("Melhor caso detectado, posição: "+ resultado.getPassosExecutados());
       }else if(casos.detectarCasoMedio()){
            System.out.println("Caso médio detectado, posição: "+ resultado.getPassosExecutados());
       } else if(casos.detectarPiorCaso()){
            System.out.println("Pior caso detectado");
       }

    }
}
