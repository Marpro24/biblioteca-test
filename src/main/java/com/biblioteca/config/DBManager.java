package com.biblioteca.config;

import java.sql.Connection;
import java.sql.DriverManager;

public  class DBManager {

  private static final String URL= "jdbc:postgresql://localhost:5432/LibraryDB";
    private static final String USER ="postgres";
    private static final String PASS ="equipo3";
  

private static Connection connection;
//metodo de la clase DBManager para iniciar la conexion con la base de datos 
public static Connection initConnection() {
  try {
    connection = DriverManager.getConnection(URL, USER, PASS);
    System.out.println("Conectado con éxito !");
  } catch (Exception e) {
    System.out.println(e.getMessage());
  }
  return connection;
}

public static void closeConnection(){
  try {
    connection.close();
    System.out.println("Conexión cerrada correctamente");
  } catch (Exception e) {
      System.out.println(e.getMessage()); 

 }
}
} 

