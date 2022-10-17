package vk.controller;

import vk.model.Book;

import java.util.List;

public class Library {
    private final int id;
    private final String address;
    private List<Book> books;

    Library(int id, String address, List<Book> books) {
        this.id = id;
        this.address = address;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
