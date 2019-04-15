package dao;

import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author fsens
 */
public interface AcaoDAO<T> {

    ArrayList<T> retornarTodos();

    int inserir(T objeto);

    int alterar(T objeto);

    int excluir(int id);

    T buscarPorId(int id);

}
