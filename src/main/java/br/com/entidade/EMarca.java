package br.com.entidade;

import br.com.generics.TransformarDados;

public class EMarca implements TransformarDados {
    
    private int idMarca =0;
    private String descricaoMarca = "";
    
    public EMarca(){}
    
    public EMarca(int idMarca, String descricaoMarca){
        this.idMarca = idMarca;
        this.descricaoMarca = descricaoMarca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescricaoMarca() {
        return descricaoMarca;
    }

    public void setDescricaoMarca(String descricaoMarca) {
        this.descricaoMarca = descricaoMarca;
    }

    @Override
    public String desmaterializar() {
       String saida = idMarca + ";";
       saida += descricaoMarca;
       return saida;
    }

    @Override
    public void materializar(String str) throws Exception {
        String[] vetor = str.split(";");
        if(vetor.length != 2) throw new Exception ("Faltam dados na String");
        idMarca = Integer.parseInt(vetor[0].trim());
        descricaoMarca = vetor[1].trim();
        
    }
        
    
}
