package dao;

import java.sql.Connection;

import models.Odontologo;
import org.apache.log4j.Logger;
import persistence.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OdontologoH2DAO implements IDAO<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoH2DAO.class);

    private static final DBConnector connector = DBConnector.getInstance();
    private static final Connection connection = connector.getConnection();

    @Override
    public ArrayList<Odontologo> listar() {
        ArrayList<Odontologo> listDB = new ArrayList<>();
        String query = "SELECT * FROM ODONTOLOGOS";

        try {
            ResultSet result = connection.createStatement().executeQuery(query);
            System.out.println("GET - OK");

            while (result.next()) {
                listDB.add(new Odontologo(result.getInt("id"), result.getString("numeroMatricula"), result.getString("nombre"), result.getString("apellido")));
            }
            logger.info("Listando odontologos en H2");

            return listDB;
        } catch (SQLException e) {
            logger.error("Error al listar odontologos en H2");
            System.out.println("GET error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void guardar(Odontologo _item) {
        String query = "INSERT INTO ODONTOLOGOS (numeroMatricula, nombre, apellido) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, _item.getNumeroMatricula());
            preparedStatement.setString(2, _item.getNombre());
            preparedStatement.setString(3, _item.getApellido());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                logger.info("Guardando odontologo en H2");
                System.out.println("POST - CREATED");
            } else {
                logger.error("Error al guardar odontologo en H2");
                System.out.println("POST - NOT CREATED");
            }
        } catch (SQLException e) {
            logger.error("Error al guardar odontologo en H2");
            System.err.println("POST error: " + e.getMessage());
        }
    }

    @Override
    public Odontologo listarPorID(int id) {
        return null;
    }

}
