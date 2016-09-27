package br.unifor.exemplo;

import br.unifor.filter.SimpleFilter;
import br.unifor.pipe.Pipe;

public class ExemploFilterSigla extends SimpleFilter<String, String> {
    public ExemploFilterSigla(Pipe<String> input, Pipe<String> output) {
        super(input, output);
    }

    @Override
    protected String transforma(String in) {
    	
    	in = in.trim();
    	String sigla = in.substring(0,1);
    	for (int i = 1; i < in.length(); ++i){
            if ( in.substring(i, i+1).equals(" ") ){
                sigla += in.substring(i+1, i+2); //.toUpperCase(); se não tiver o filtro anterior
            }
    	}
    	
        System.out.println("Filtro Sigla: transforma de " + in + " para " + sigla);
        delayForDebug(100);
        return sigla;
    }
}