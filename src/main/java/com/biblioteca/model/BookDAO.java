package com.biblioteca.model;
import java.sql.Connection;
import java.sql.Statement;
import com.biblioteca.config.DBManager;

public class BookDAO {
  //aqui creamos un perro a traves de la terminal que modifique la base de datos
  //CRUD tb podemos tener aquí otro método para cambiar el is rented, por ejemplo. Todo lo que tenga que ver con bs viene aquí
  public void createBook(String title, String description, String isbn, int idGenre, Integer[] authorIds ) throws SQLException {
    Book[] books = this.searchByTitle(title);
    if (books.length > 0) {
        System.out.println("El libro ya existe en la base de datos.");
        return;
    }
    if (description.length() > 200) {
        System.out.println("La descripción no puede exceder los 200 caracteres.");
        return;
    }
    Connection conn = DBManager.initConnection();
    String query = "INSERT INTO Book (title, description, isbn, idGenre) VALUES (?, ?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    pstmt.setString(1, title);
    pstmt.setString(2, description);
    pstmt.setString(3, isbn);
    pstmt.setInt(4, idGenre);
    pstmt.executeUpdate();

  }    

}