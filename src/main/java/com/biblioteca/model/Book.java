package com.biblioteca.model;

public class Book {
  private int id;
  private String title;
  private String genre;
  private String author;
  private String description;
  private Long isbn;

  public Book(String title, String genre, String author, String description, long isbn){
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.description = description;
    this.isbn = isbn;

  }

    public Book(String title, String genre, String author, long isbn){
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.isbn = isbn;

  }


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

  public long getIsbn() {
    return this.isbn;
  }

  public void setIsbn(long isbn) {
    this.isbn = isbn;
  }



}
