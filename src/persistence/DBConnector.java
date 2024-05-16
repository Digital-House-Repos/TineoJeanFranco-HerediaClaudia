package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static DBConnector instance = null;
    private Connection connection = null;

    private DBConnector() {
    }

    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

    private void connectToDB() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        // Contenedor de docker en puerto 9092 & sin contraseña ni usuario
        String databaseURL = "jdbc:h2:tcp://172.17.0.2:9092/demo1";
        String databaseUser = "";
        String databasePassword = "";

        connection = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);

        System.out.println("Successful connection");
        String databaseName = connection.getMetaData().getDatabaseProductName();
        String databaseVersion = connection.getMetaData().getDatabaseProductVersion();
        System.out.println(databaseName + " " + databaseVersion);
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                this.connectToDB();
            }
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error DB: " + e.getMessage());
            return null;
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
