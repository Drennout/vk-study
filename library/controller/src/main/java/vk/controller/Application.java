package vk.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vk.model.Book;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        //Есть 3 автора: Author1, Author2, Author3
        String author = new Scanner(System.in).next();

        LibraryFactory libraryFactory = new LibraryFactory();
        Set<Library> libraries = libraryFactory.findLibrariesByAuthorName(author);
        Set<Book> books = new HashSet<>();

        for (Library lib : libraries) {
            for (Book book : lib.getBooks()) {
                if(book.getAuthor().getName().equals(author)) {
                    books.add(book);
                }
            }
        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        System.out.println("Author books");
        System.out.println(gson.toJson(books));

        System.out.println("\nLibs with author books");
        System.out.println(gson.toJson(libraries));
    }
}
