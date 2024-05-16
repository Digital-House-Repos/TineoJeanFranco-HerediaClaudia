package dao;

import java.util.ArrayList;

public interface IDAO<T> {
    void guardar(T t);

    T listarPorID(int id);

    ArrayList<T> listar();
}
