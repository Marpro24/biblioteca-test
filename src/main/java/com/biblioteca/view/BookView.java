package com.biblioteca.view;
import java.util.Scanner;

import com.biblioteca.controller.BookController;
import com.biblioteca.model.Book;

public class BookView {
  private BookController bookController;

  public BookView(BookController bookController){ 
    this.bookController = bookController;
  }

  /*public void createBook(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa un titulo ");
    String title = scanner.nextLine();
    System.out.println("Ingresa un autor");
    String author = scanner.nextLine();
    System.out.println("Ingresa el ISBN");
    int isbn = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Ingresa descripción del libro");
    String description = scanner.nextLine();
    System.out.println("Ingresa género del libro");
    String genre = scanner.nextLine();
   
    Book book = new Book(title, genre, author, description, isbn );
    bookController.createBook(book);
   
    scanner.close();
    
  }*/

  public void updateBook(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa el ID del libro que quieres actualizar:");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Ingresa un nuevo titulo ");
    String title = scanner.nextLine();
    System.out.println("Ingresa un nuevo autor");
    String author = scanner.nextLine();
    System.out.println("Ingresa un nuevo ISBN");
    Long isbn = scanner.nextLong();
    scanner.nextLine();
    System.out.println("Ingresa nueva descripción del libro");
    String description = scanner.nextLine();
    System.out.println("Ingresa un nuevo género");
    String genre = scanner.nextLine();
    Book book = new Book(title, genre, author, description, isbn );
    book.setId(id);
    bookController.updateBook(book);
    scanner.close();
    
    }
    
}
