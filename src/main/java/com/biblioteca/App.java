package com.biblioteca;

import com.biblioteca.controller.BookController;
import com.biblioteca.model.Book;
import com.biblioteca.model.BookDAO;
import com.biblioteca.view.BookView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Biblioteca Proyect" );

       // DBManager.initConnection();
       // DBManager.closeConnection(); 
        
        //Instanciamos Book, creamos un objeto de tipo book

        //System.out.println(item.getTitle());
        
        //creamos el bookdao para poder acceder al metodo y establecer la conexión con la BD
        // BookDAO model = new BookDAO();
        //model.createBook(item);
        //y con esto se debería crear un item nuevo en postgress
        //para instanciar al controlador
        Book item = new Book("Jazz", "fiction", "ToniMorrison", "blsbls", 154775);
        System.out.println(item);
        //esto esta mal porque no lo ponemos a chapa así aquí, hacemos una vista para que el cliente pueda introducir la info directamente
       /* BookDAO model = new BookDAO();
        BookController bookController = new BookController(model);
        bookController.createBook((item)); */

        BookDAO model = new BookDAO();
        BookController bookController = new BookController(model);
        BookView bookView = new BookView(bookController);

        bookView.createBook();

        
    }
}
