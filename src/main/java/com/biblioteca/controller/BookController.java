package com.biblioteca.controller;

import com.biblioteca.model.Book;
import com.biblioteca.model.BookDAO;
import java.util.List;

public class BookController {
private BookDAO bookDAO;

public BookController(BookDAO bookDAO){
  this.bookDAO = bookDAO;
}

public void createBook(Book book){ 
  bookDAO.createBook(book);
}

public void updateBook(Book book){
  bookDAO.updateBook(book);
  }

public List<Book> findBookByTitle(String title){
  return bookDAO.findBookByTitle(title);
}

public void deleteBook(int id){ 
  bookDAO.deleteBook(id);
}

public List<Book> getAllBooks() {
  return bookDAO.getAllBooks();
}
}
