package com.biblioteca;

import com.biblioteca.controller.BookController;
import com.biblioteca.model.BookDAO;
import com.biblioteca.view.BookView;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Biblioteca Proyect" );
        BookDAO bookDAO = new BookDAO();
        BookController bookController = new BookController(bookDAO);
        BookView bookView = new BookView(bookController);

        bookView.createBook();
        bookView.findBookByTitle();
        bookView.updateBook();
        bookView.deleteBook();
        
    }
}
