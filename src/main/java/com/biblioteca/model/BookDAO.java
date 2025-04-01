package com.biblioteca.model;
import java.sql.Connection;
import java.sql.Statement;
import com.biblioteca.config.DBManager;

public class BookDAO {
  //aqui creamos un perro a traves de la terminal que modifique la base de datos
  //CRUD tb podemos tener aquí otro método para cambiar el is rented, por ejemplo. Todo lo que tenga que ver con bs viene aquí

  public void createBook(Book book){
    //necesitamos el objeto primero, que viene desde Book, se lo pasamos por parametro
    try {
      Connection connection = DBManager.initConnection();
      Statement stm = connection.createStatement(); //prepara la query para pasarla a la BD
      //insertamos la tabla 
      String sql = "INSERT INTO dogs (title, author, genre, description, isbn, is_rented) VALUES ('" + book.getTitle() + "', " +  book.getAuthor() + book.getGenre() + book.getDescription() + book.getIsbn() + ", false)";
      stm.executeUpdate(sql);
      System.out.println(book.getTitle() + "añadido correctamente"); 
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      DBManager.closeConnection();
    }


  }
}
