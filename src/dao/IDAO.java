package dao;

import java.util.ArrayList;

public interface IDAO<T> {
    String guardar(T t);

    ArrayList<T> listar();
}
