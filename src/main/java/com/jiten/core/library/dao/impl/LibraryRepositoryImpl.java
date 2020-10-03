package com.jiten.core.library.dao.impl;

import com.jiten.core.library.dao.LibraryRepository;
import com.jiten.core.library.model.Book;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

    List<Book> books = new ArrayList<>();

    @PostConstruct
    public void init() {
        Book book = new Book();
        book.setName("book1");
        book.setAuthor("author1");
        books.add(book);
        book = new Book();
        book.setName("book2");
        book.setAuthor("author2");
        books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookByName(String bookName) {
        Optional<Book> book = books.stream().filter(e -> e.getName().equalsIgnoreCase(bookName)).findAny();
        return book.orElseThrow(() -> new NoSuchElementException("No Book is available with this name"));
    }

    @Override
    public void removeBook(Book bookByName) {
        books.remove(bookByName);
    }
}
