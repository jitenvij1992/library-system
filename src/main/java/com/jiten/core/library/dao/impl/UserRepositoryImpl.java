package com.jiten.core.library.dao.impl;

import com.jiten.core.library.dao.UserRepository;
import com.jiten.core.library.model.Book;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    List<Book> userBooks;

    @PostConstruct
    public void init() {
        userBooks = new ArrayList<>();
    }

    @Override
    public List<Book> getUserBooks() {
        return userBooks;
    }

    @Override
    public void addBook(Book book) {
        userBooks.add(book);
    }
}
