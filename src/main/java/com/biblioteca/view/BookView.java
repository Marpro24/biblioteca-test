package com.biblioteca.view;

import java.util.Scanner;

import com.biblioteca.controller.BookController;
import com.biblioteca.model.Book;

public class BookView {
  private BookController bookController;

  public BookView(BookController bookController){ //creamos un metodo constructor en el que le pasamos un controlador a la vista xq la vista depende del controller
    this.bookController = bookController;
  }

  public void createBook(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa un titulo ");
    String title = scanner.nextLine();
    System.out.println("Ingresa un autor");
    String author = scanner.nextLine();
    //etc....
    Book book = new Book(title, title , author, author, 0);
    bookController.createBook(book);
    scanner.close();
    
  }
}
