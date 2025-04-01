/*package com.biblioteca.model;
//import java.sql.Connection;
//import java.sql.Statement;
//import com.biblioteca.config.DBManager;

public class AuthorDAO{

    try{
        Connection connection = DBManager.initConnection();
        Statement stm = connection.createStatement();
        String sql =  "INSERT INTO dogs (title, author)";
        stm.executeUpdate(sql);
        System.out.println(book.getAuthor() + "añadido correctamente");
    } catch (Exception e){
        System.out.println(e.getMessage());
    }finally{
        DBManager.closeConnection();
    }
} 


*/