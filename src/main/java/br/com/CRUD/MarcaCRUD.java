
package br.com.CRUD;

import br.com.entidade.EMarca;
import java.util.ArrayList;


public interface MarcaCRUD {
    void incluir(EMarca objeto)throws Exception;
    ArrayList<EMarca> listagem()throws Exception;
    void excluir(String nome) throws Exception;
    
}
