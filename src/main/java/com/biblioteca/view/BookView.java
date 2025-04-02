package com.biblioteca.view;
import java.util.List;
import java.util.Scanner;

import com.biblioteca.controller.BookController;
import com.biblioteca.model.Book;

public class BookView {
  private BookController bookController;

  public BookView(BookController bookController){ 
    this.bookController = bookController;
  }

  public void createBook(){
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
    
  }

  public void displayBooks(List<Book> books) {

    if (books.isEmpty()) {
      System.out.println("There are no books yet.");
      
  } else {
    books.forEach(book -> {
      System.out.println("ID: " + book.getId());
      System.out.println("Title: " + book.getTitle());
      System.out.println("Author: " + book.getAuthor());
      System.out.println("Description: " + book.getDescription());
      System.out.println("Genre: " + book.getGenre());
      System.out.println("ISBN: " + book.getIsbn());
      System.out.println("------------------");
    });
    
  }
  }

}