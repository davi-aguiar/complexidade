package br.edu.ifba.busca.impl;

import br.edu.ifba.busca.casos.Casos;

public class CasosImpl extends Casos {
    private int limiarMelhorCaso = 0 ;

    

    public CasosImpl(int limiarMelhorCaso) {
        this.limiarMelhorCaso = limiarMelhorCaso;
    }

    // Estar dentro do limiar de posições otimas do vetor 
    @Override
    public boolean detectarMelhorCaso() {
       boolean detectado = false;
        if (resultadoBusca.isEncontrado() && resultadoBusca.getPassosExecutados() <= limiarMelhorCaso){
            detectado = true;
        }

       return detectado;
        
    }

    // O numero é encotrado, mas não está dentro do limiar
    @Override
    public boolean detectarCasoMedio() {
      boolean detectado =  false;
      
      if(resultadoBusca.isEncontrado() && resultadoBusca.getPassosExecutados() > limiarMelhorCaso){
          detectado = true;
      }


      return detectado;
       
    }

    // O  numero desejado não estar no vetor
    @Override
    public boolean detectarPiorCaso() {

     boolean detectado = true;

     if(resultadoBusca.isEncontrado()){
         detectado = false;
     }
        
    return detectado;
    }   
}
