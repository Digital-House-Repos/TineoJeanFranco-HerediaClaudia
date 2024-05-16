package service;

import dao.IDAO;
import models.Odontologo;

import java.util.ArrayList;

public class OdontologoService {
    private final IDAO<Odontologo> odontologoiDao;

    public OdontologoService(IDAO<Odontologo> odontologoiDao) {
        this.odontologoiDao = odontologoiDao;
    }

    public String guardarOdontologo(Odontologo odontologo) {
        return odontologoiDao.guardar(odontologo);
    }

    public ArrayList<Odontologo> listarTodosOdontologos() {
        return odontologoiDao.listar();
    }
}
