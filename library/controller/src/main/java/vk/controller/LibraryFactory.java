package vk.controller;

import vk.model.Author;
import vk.model.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class LibraryFactory {
    private final List<Library> libraries;

    LibraryFactory() {
        libraries = new ArrayList<>();
        setLibraries();
    }

    private Book getRandomBook(List<Book> books) {
        return books.get(ThreadLocalRandom.current().nextInt(0, 12));
    }

    private void setLibraries() {
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();

        // Создаем авторов
        for (int i = 0; i < 3; i++) {
            authors.add(new Author(i, "Author" + i));
        }


        // Создаем книги (у книги рандомный автор)
        for (int i = 0; i < 12; i++) {
            books.add(new Book(i, "book" + i, authors.get(ThreadLocalRandom.current().nextInt(1, 3))));
        }


        // Создаем 3 библиотеки
        this.libraries.add(new Library(1, "address1", new ArrayList<>()));
        this.libraries.add(new Library(2, "address2", new ArrayList<>()));
        this.libraries.add(new Library(3, "address3", new ArrayList<>()));

        // Заполняем библиотеку книгами
        for (int i = 0; i < this.libraries.size(); i++) {
            Set<Book> libBooks = new HashSet<>();
            // Рандомим список книг в билбоиотеке
            for (int j = 0; j < ThreadLocalRandom.current().nextInt(1, 12); j++) {
                libBooks.add(getRandomBook(books));
            }
            // Добавляем книги в библиотеку
            Library lib = libraries.get(i);
            lib.setBooks(new ArrayList<>(libBooks));
            libraries.set(i, lib);
        }
    }

    public Set<Library> findLibrariesByAuthorName (String author) {
        Set<Library> libraryList = new HashSet<>();
        for (Library lib : libraries) {
            for (Book book : lib.getBooks()) {
                if (book.getAuthor().getName().equals(author)) {
                    libraryList.add(lib);
                    break;
                }
            }
        }
        return libraryList;
    }
}
