package com.biblioteca.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/LibraryDB";
    private static final String USER = "postgres";
    private static final String PASS = "equipo3";

    private static Connection connection;

    public static Connection initConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Conectado con éxito!");
            } catch (SQLException e) {
                System.out.println("Error de conexión: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
