package br.com.negocio;

import br.com.CRUD.MarcaCRUD;
import br.com.entidade.EMarca;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class NMarca implements MarcaCRUD {

    private String nomeDoArquivoNoDisco = null;

    public NMarca(String nomeDoArquivoNoDisco) {
        this.nomeDoArquivoNoDisco = nomeDoArquivoNoDisco;
    }

    @Override
    public void incluir(EMarca objeto) throws Exception {
        try {

            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(objeto.desmaterializar() + "\n");

            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ArrayList<EMarca> listagem() throws Exception {
        try {
            ArrayList<EMarca> vetorMarca = new ArrayList<>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                EMarca objetoMarca = new EMarca();
                objetoMarca.materializar(linha);
                vetorMarca.add(objetoMarca);
            }
            br.close();
            return vetorMarca;
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void excluir(String nome) throws Exception {
        try {
            ArrayList<EMarca> vetorMarca = listagem();
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int pos = 0; pos < vetorMarca.size(); pos++) {
                EMarca aux = vetorMarca.get(pos);
                if (!(aux.getDescricaoMarca().equals(nome))) {
                    bw.write(aux.desmaterializar() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

}
