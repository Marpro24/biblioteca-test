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
        int option = 0;
        do {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Crear un libro");
            System.out.println("2. Actualizar un libro");
            System.out.println("3. Buscar un libro por título");
            System.out.println("4. Eliminar un libro");
            System.out.println("5. Buscar un libro por autor");
            System.out.println("6. Buscar un libro por género");
            System.out.println("7. Mostrar todos los libros");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1: createBook(); break;
                case 2: updateBook(); break;
                case 3: findBookByTitle(); break;
                case 4: deleteBook(); break;
                case 5: findBookByAuthor(); break;
                case 6: findBookByGenre(); break;
                case 7: displayBooks(bookController.getAllBooks()); break;
                case 8: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (option != 8);
    }

    public void createBook() {
        System.out.println("Ingresa un título:");
        String title = scanner.nextLine();
        System.out.println("Ingresa un autor:");
        String author = scanner.nextLine();
        System.out.println("Ingresa el ISBN:");

        Long isbn;
        while (!scanner.hasNextLong()) {
            System.out.println("Por favor, ingresa un número válido para el ISBN:");
            scanner.next();
        }
        isbn = scanner.nextLong();
        scanner.nextLine(); // Limpia el buffer

        System.out.println("Ingresa descripción del libro:");
        String description = scanner.nextLine();
        System.out.println("Ingresa género del libro:");
        String genre = scanner.nextLine();

        Book book = new Book(title, genre, author, description, isbn);
        bookController.createBook(book);
    }

    public void updateBook() {
        System.out.println("Ingresa el ID del libro que quieres actualizar:");
        
        if (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.nextLine();
            return;
        }
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresa un nuevo título:");
        String title = scanner.nextLine();
        System.out.println("Ingresa un nuevo autor:");
        String author = scanner.nextLine();
        System.out.println("Ingresa un nuevo ISBN:");

        Long isbn;
        while (!scanner.hasNextLong()) {
            System.out.println("Por favor, ingresa un número válido para el ISBN:");
            scanner.next();
        }
        isbn = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Ingresa nueva descripción del libro:");
        String description = scanner.nextLine();
        System.out.println("Ingresa un nuevo género:");
        String genre = scanner.nextLine();

        Book book = new Book(title, genre, author, description, isbn);
        book.setId(id);
        bookController.updateBook(book);
    }

    public void findBookByTitle() {
        System.out.println("Por favor, ingresa un título:");
        String title = scanner.nextLine();

        List<Book> books = bookController.findBookByTitle(title);

        if (books.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            System.out.println("Resultados:");
            for (Book book : books) {
                System.out.println("Título: " + book.getTitle());
                System.out.println("Género: " + book.getGenre());
                System.out.println("Autor: " + book.getAuthor());
                System.out.println("Descripción: " + book.getDescription());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("------------------");
            }
        }
    }

    public void deleteBook() {
      System.out.println("Ingresa el ID del libro a eliminar:");
      int id = scanner.nextInt();
      scanner.nextLine();
      bookController.deleteBook(id);
  }
  

    public void findBookByAuthor() {
        System.out.println("Por favor, ingresa un autor:");
        String author = scanner.nextLine();

        List<Book> books = bookController.findBookByAuthor(author);

        if (books.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            System.out.println("Resultados:");
            for (Book book : books) {
                System.out.println("Título: " + book.getTitle());
                System.out.println("Género: " + book.getGenre());
                System.out.println("Autor: " + book.getAuthor());
                System.out.println("Descripción: " + book.getDescription());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("------------------");
            }
        }
    }

    public void findBookByGenre() {
        System.out.println("Por favor, ingresa un género:");
        String genre = scanner.nextLine();

        List<Book> books = bookController.findBookByGenre(genre);

        if (books.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            System.out.println("Resultados:");
            for (Book book : books) {
                System.out.println("Título: " + book.getTitle());
                System.out.println("Género: " + book.getGenre());
                System.out.println("Autor: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("------------------");
            }
        }
    }

    public void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Todavía no hay libros en la base.");
        } else {
            books.forEach(book -> {
                System.out.println("ID: " + book.getId());
                System.out.println("Título: " + book.getTitle());
                System.out.println("Género: " + book.getGenre());
                System.out.println("Autor: " + book.getAuthor());
                System.out.println("Descripción: " + book.getDescription());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("------------------");
            });
        }
    }
}
