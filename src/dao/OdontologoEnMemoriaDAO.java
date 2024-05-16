package dao;

import models.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class OdontologoEnMemoriaDAO implements IDAO<Odontologo> {
    private final ArrayList<Odontologo> odontologos;
    private static final Logger logger = Logger.getLogger(OdontologoEnMemoriaDAO.class);

    public OdontologoEnMemoriaDAO() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public String guardar(Odontologo odontologo) {
        logger.info("Guardando odontologo en memoria");
        odontologos.add(odontologo);
        return "Odontologo guardado en memoria";
    }

    @Override
    public ArrayList<Odontologo> listar() {
        logger.info("Listando odontologos en memoria");
        return odontologos;
    }
}
