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
}
