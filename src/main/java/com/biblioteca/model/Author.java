package com.biblioteca.model;

public class Author {

    private int idAuthor;
    private String nameAuthor;

    public Author(String nameAuthor){

      this.nameAuthor = nameAuthor;
    }

    public int getIdAuthor() {
        return idAuthor;
    }
    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }
    public String getNameAuthor() {
        return nameAuthor;
    }
    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }


}
