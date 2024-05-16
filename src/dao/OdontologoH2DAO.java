package dao;

import java.sql.Connection;

import models.Odontologo;
import org.apache.log4j.Logger;
import persistence.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OdontologoH2DAO implements IDAO<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoH2DAO.class);

    @Override
    public ArrayList<Odontologo> listar() {
        DBConnector connector = DBConnector.getInstance();
        Connection connection = connector.getConnection();

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
        } finally {
            connector.closeConnection();
        }
    }

    @Override
    public String guardar(Odontologo _item) {
        DBConnector connector = DBConnector.getInstance();
        Connection connection = connector.getConnection();

        String query = "INSERT INTO ODONTOLOGOS (numeroMatricula, nombre, apellido) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, _item.getNumeroMatricula());
            preparedStatement.setString(2, _item.getNombre());
            preparedStatement.setString(3, _item.getApellido());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                logger.info("Guardando odontologo en H2");
                System.out.println("POST - CREATED");
                return "Odontologo guardado en H2";
            } else {
                logger.error("Error al guardar odontologo en H2");
                System.out.println("POST - NOT CREATED");
                return "Odontologo no guardado en H2";
            }
        } catch (SQLException e) {
            logger.error("Error al guardar odontologo en H2");
            System.err.println("POST error: " + e.getMessage());
            return "Odontologo no guardado en H2. Error en la base de datos";
        } finally {
            connector.closeConnection();
        }
    }
}
