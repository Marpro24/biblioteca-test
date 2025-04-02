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

   /*  public void createBook(Book book) {
        String sql = "INSERT INTO book (title, genre, author, description, isbn) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmn = connection.prepareStatement(sql)) {
            stmn.setString(1, book.getTitle());
            stmn.setString(2, book.getGenre());
            stmn.setString(3, book.getAuthor());
            stmn.setInt(4, book.getDescription());  
            stmn.setString(5, book.getIsbn());  

            stmn.executeUpdate();
            System.out.println("Libro añadido correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el libro: " + e.getMessage());
        }
    }*/

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
}
 