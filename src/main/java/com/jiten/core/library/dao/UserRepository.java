package com.jiten.core.library.dao;

import com.jiten.core.library.model.Book;

import java.util.List;

public interface UserRepository {

    List<Book> getUserBooks();

    void addBook(Book book);
}
