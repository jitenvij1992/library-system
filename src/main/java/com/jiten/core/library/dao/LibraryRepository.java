package com.jiten.core.library.dao;

import com.jiten.core.library.model.Book;

import java.util.List;

public interface LibraryRepository {

    List<Book> getAllBooks();

    Book getBookByName(String bookName);

    void removeBook(Book bookByName);
}
