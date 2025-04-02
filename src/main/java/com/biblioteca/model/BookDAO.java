package com.biblioteca.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.biblioteca.config.DBManager;



public class BookDAO {
    private Connection connection;

    public BookDAO() {
        this.connection = DBManager.initConnection();
    }

   public void createBook(Book book) {
        String sql = "INSERT INTO book (title, genre, author, description, isbn) VALUES (?, ?, ?, ?, ?)";

    try (PreparedStatement stmn = connection.prepareStatement(sql)) {
            stmn.setString(1, book.getTitle());
            stmn.setString(2, book.getGenre());
            stmn.setString(3, book.getAuthor());
            stmn.setString(4, book.getDescription());  
            stmn.setLong(5, book.getIsbn());  

            stmn.executeUpdate();
            System.out.println("Libro añadido correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el libro: " + e.getMessage());
        }
    }

    public void updateBook(Book book) {
        String sql = "UPDATE book SET title = ?, genre = ?, author = ?, description = ?, isbn = ? WHERE id = ?";
        try (PreparedStatement stmn = connection.prepareStatement(sql)) {
        stmn.setString(1, book.getTitle());

        stmn.setString(2, book.getGenre());
        stmn.setString(3, book.getAuthor());
        stmn.setString(4, book.getDescription()); 
        stmn.setLong(5, book.getIsbn()); 
        stmn.setLong(6, book.getId());
        stmn.executeUpdate();
        System.out.println("Libro actualizado correctamente.");
        } catch (SQLException e) {
        System.out.println("Error al insertar el libro: " + e.getMessage());
        }
        }
    
    public List<Book> findBookByTitle(String title){
        String sql = "SELECT * FROM book WHERE title LIKE ?";
        List<Book> books = new ArrayList<>();


        try {

           PreparedStatement statement = connection.prepareStatement(sql);
           
           statement.setString(1, "%" + title + "%");
           
           ResultSet result = statement.executeQuery();

            while (result.next()) {
                String retrievedTitle = result.getString("title");
                String genre = result.getString("genre");
                String author = result.getString("author");
                String description = result.getString("description");
                int isbn = result.getInt("isbn");

               Book book = new Book(retrievedTitle, genre, author, description, isbn);

               books.add(book);
            }
            
        } catch (Exception e) {
             System.out.println("Error al buscar el libro: " + e.getMessage());
        }
       return books;
    }

    public void deleteBook(int id) {
        try {
            String sql = "DELETE FROM Book WHERE id=" + id;
            PreparedStatement stmn = connection.prepareStatement(sql);
            stmn.executeUpdate();
            System.out.println("Libro eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
        }
      }

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
    long isbn = (resultSet.getLong("isbn"));

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


  
 
  
 