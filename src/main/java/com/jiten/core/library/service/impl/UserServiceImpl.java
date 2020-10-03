package com.jiten.core.library.service.impl;

import com.jiten.core.library.dao.LibraryRepository;
import com.jiten.core.library.dao.UserRepository;
import com.jiten.core.library.model.Book;
import com.jiten.core.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public void borrowBook(String bookName) {
        List<Book> userBooks = userRepository.getUserBooks();
        if(userBooks != null && userBooks.size() < 2) {
            Book bookByName = libraryRepository.getBookByName(bookName);
            userRepository.addBook(bookByName);
            libraryRepository.removeBook(bookByName);
        }
    }
}
