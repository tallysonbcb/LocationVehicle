
package br.com.generics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorID {
    
    private int identificador = 0;
    //ALTERAR CAMINHO DO ARQUIVO
    String nomeDoArquivo ="/home/bruno/DadosPI.txt";
    
    public GeradorID() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(nomeDoArquivo);
        try (BufferedReader br = new BufferedReader(fr)) {
            String linha=br.readLine();
            identificador = Integer.parseInt(linha);
        }
    }
    public int getIdentificadorContato(){
        return ++identificador;
    }
    
    public void finalize() throws IOException{
         
         FileWriter fw = new FileWriter(nomeDoArquivo,false);
        try ( 
                BufferedWriter bw = new BufferedWriter(fw)) {
            String saida = identificador + "";
            bw.write(saida);
        }		
    }
    
}
