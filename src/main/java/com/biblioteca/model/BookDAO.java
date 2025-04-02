package com.biblioteca.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.config.DBManager;



public class BookDAO {
  //aqui creamos un perro a traves de la terminal que modifique la base de datos
  //CRUD tb podemos tener aquí otro método para cambiar el is rented, por ejemplo. Todo lo que tenga que ver con bs viene aquí

  private PreparedStatement stmn;
    private Connection connection;

  public void createBook(Book book) {
    try {
      connection = DBManager.initConnection();
      String sql = "INSERT INTO Book (title, description, isbn, genre) VALUES (?, ?, ?, ?)";
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

 /* public BookDAO(){
try {
    this.connection = DBManager.initConnection();
} catch (SQLException e) {
  System.out.println(e.getMessage());
}
finally {
  DBManager.closeConnection();
}
  }*/

public List<Book> getAllBooks() {
List<Book> books = new ArrayList<>();
String query = "SELECT * FROM book";

try (Statement statement = connection.createStatement()) {
  ResultSet resultSet = statement.executeQuery(query);
  while (resultSet.next()) {
    
    String title = (resultSet.getString("title"));
    String author = (resultSet.getString("author"));
    String genre= (resultSet.getString("genre"));
    String description = (resultSet.getString("description"));
    int isbn = (resultSet.getInt("isbn"));

    Book book = new Book(title, author, genre, description, isbn);
    book.setId(resultSet.getInt("id"));
    books.add(book);
  }
}  catch (SQLException e) {
  System.out.println(e.getMessage());
}

return books;

}

  }

  
 
  
