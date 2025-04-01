package com.biblioteca.model;
import java.sql.Connection;
import com.biblioteca.config.DBManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class BookDAO {
  //aqui creamos un perro a traves de la terminal que modifique la base de datos
  //CRUD tb podemos tener aquí otro método para cambiar el is rented, por ejemplo. Todo lo que tenga que ver con bs viene aquí

  private PreparedStatement stmn;
    private Connection connection;

  public void createBook(Book book) {
    try {
      connection = DBManager.initConnection();
      String sql = "INSERT INTO Book (title, description, isbn, idGenre) VALUES (?, ?, ?, ?)";
      stmn = connection.prepareStatement(sql);
      stmn.setString(2, book.getTitle());
      stmn.setString(4, book.getGenre());
      stmn.setString(1, book.getAuthor());
      stmn.setString(3, book.getDescription()); //corregir posición
      stmn.setInt(3, book.getIsbn());
      stmn.executeUpdate();
      System.out.println("Libro añadido correctamente.");
  } catch (SQLException e) {
      System.out.println("Error al insertar el libro: " + e.getMessage());
  } finally {
      DBManager.closeConnection();
  }
  }

  }
  
 
  
