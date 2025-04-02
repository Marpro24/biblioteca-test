package com.biblioteca.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.config.DBManager;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        this.connection = DBManager.initConnection();
    }

    public void createBook(Book book) {
        String sql = "INSERT INTO book (title, author, description, isbn, genre) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmn = connection.prepareStatement(sql)) {
            stmn.setString(1, book.getTitle());
            stmn.setString(2, book.getAuthor());
            stmn.setString(3, book.getDescription());
            stmn.setInt(4, book.getIsbn());  
            stmn.setString(5, book.getGenre());  

            stmn.executeUpdate();
            System.out.println("Libro añadido correctamente.");
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
}
