package dao;

import models.Odontologo;

import java.util.ArrayList;

public class OdontologoEnMemoriaDAO implements IDAO<Odontologo> {
    private final ArrayList<Odontologo> odontologos;

    public OdontologoEnMemoriaDAO() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public void guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
    }

    @Override
    public Odontologo listarPorID(int id) {
        return null;
    }

    @Override
    public ArrayList<Odontologo> listar() {
        return odontologos;
    }
}
