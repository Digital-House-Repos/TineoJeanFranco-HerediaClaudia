package service;

import dao.IDAO;
import models.Odontologo;

import java.util.ArrayList;

public class OdontologoService {
    private final IDAO<Odontologo> odontologoiDao;

    public OdontologoService(IDAO<Odontologo> odontologoiDao) {
        this.odontologoiDao = odontologoiDao;
    }

    public void guardarOdontologo(Odontologo odontologo) {
        odontologoiDao.guardar(odontologo);
    }

    public Odontologo listarOdontologo(int id) {
        return odontologoiDao.listarPorID(id);
    }

    public ArrayList<Odontologo> listarTodosOdontologos() {
        return odontologoiDao.listar();
    }
}
