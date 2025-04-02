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

  public void findBookByTitle(){
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Por favor, ingresa un título");
    String title = scanner.nextLine();

   List<Book> books = bookController.findBookByTitle(title);
   
   if (books.isEmpty()) {
    System.out.println("No se encontraron resultados");
    
   } else {
    System.out.println("Resultados: ");
    for (Book book : books) {
      
      System.out.println("Título: " + book.getTitle());
      System.out.println("Género: " + book.getGenre());
      System.out.println("Autor: " + book.getAuthor()); 
      System.out.println("Descripción: " + book.getDescription());
      System.out.println("Isbn: " + book.getIsbn());
    }
   }

    scanner.close();
  }
}
