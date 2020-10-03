package com.jiten.core.library.service.impl;

import com.jiten.core.library.dao.LibraryRepository;
import com.jiten.core.library.model.Book;
import com.jiten.core.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public List<Book> getAllBooks() {
        return libraryRepository.getAllBooks();
    }
}
