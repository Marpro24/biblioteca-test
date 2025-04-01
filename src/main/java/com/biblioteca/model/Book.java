package com.biblioteca.model;

public class Book {
  private int id;
  private String title;
  private String genre;
  private String author;
  private String description;
  private int isbn;
  private boolean isRented;

  public Book(String title, String genre, String author, String description, int isbn){
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.description = description;
    this.isbn = isbn;
    this.isRented = false;   

  }
// getters y setters para acceder a las propiedades

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getGenre() {
    return this.genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getIsbn() {
    return this.isbn;
  }

  public void setIsbn(int isbn) {
    this.isbn = isbn;
  }


  public boolean getIsRented() {
    return this.isRented;
  }

  public void setIsRented(boolean isRented) {
    this.isRented = isRented;
  }

}
