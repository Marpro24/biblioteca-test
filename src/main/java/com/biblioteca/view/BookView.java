package com.biblioteca.view;

import java.util.List;
import java.util.Scanner;
import com.biblioteca.controller.BookController;
import com.biblioteca.model.Book;

public class BookView {
    private BookController bookController;
    private Scanner scanner;

    public BookView(BookController bookController) {
        this.bookController = bookController;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
      int option;
      do {
        System.out.println("\n--- Menú Biblioteca ---");
        System.out.println("1. Crear un libro");
        System.out.println("2. Actualizar un libro");
        System.out.println("3. Buscar un libro por título");
        System.out.println("4. Eliminar un libro");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        option = scanner.nextInt();
        scanner.nextLine(); 
          switch (option) {
          case 1:
          createBook();
          break;
          case 2:
          updateBook();
          break;
          case 3:
          findBookByTitle();
          break;
          case 4:
          deleteBook();
          break;
          case 5:
          System.out.println("Saliendo del sistema...");
          break;
          default:
          System.out.println("Opción no válida, intente de nuevo.");
          }
        } while (option != 5);
        scanner.close();
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

  public void deleteBook(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa el id del libro a eliminar");
    int id = scanner.nextInt();
    if (id <= 0) {
      System.out.println("El id no puede ser menor o igual a 0.");
    }else{
      bookController.deleteBook(id);
    }
    scanner.close();
    
  }

    public void findBookByAuthor(){
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Por favor, ingresa un autor");
    String author = scanner.nextLine();

   List<Book> books = bookController.findBookByAuthor(author);
   
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

  public void findBookByGenre(){
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Por favor, ingresa un género");
    String genre = scanner.nextLine();

   List<Book> books = bookController.findBookByGenre(genre);
   
   if (books.isEmpty()) {
    System.out.println("No se encontraron resultados");
    
   } else {
    System.out.println("Resultados: ");
    for (Book book : books) {
      
      System.out.println("Título: " + book.getTitle());
      System.out.println("Género: " + book.getGenre());
      System.out.println("Autor: " + book.getAuthor()); 
      System.out.println("Isbn: " + book.getIsbn());
    }
   }

    scanner.close();
  }
}
