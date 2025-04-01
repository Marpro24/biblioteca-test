package com.biblioteca.controller;

import com.biblioteca.model.Book;
import com.biblioteca.model.BookDAO;

public class BookController {
  //el controlador tiene que llamar al modelo para poder conectarse a la base de datos y el modelo me tiene que devolver la respuesta de la bs para yo (?) pasarsela a la vista 
//BookDAO bookDAO = new BookDAO(); para poder acceder a los metodos createBook del BookDao y que me devuelva algo y yo desde el controller le paso a la vista
//pero no hacemos esto lol, porque D de SOLID

BookDAO bookDAO;
//cada vez que creemos un controlador tenemos que crear un dao de esa clase
public BookController(BookDAO bookDAO){
  this.bookDAO = bookDAO;
}

public void createBook(Book book){ 
//createBook me pide un objeto, un libro, que le paso por parametro, xq tiene que ser creado por fuera, y luego le paso el objeto abajo 
  bookDAO.createBook(book);
}


}
