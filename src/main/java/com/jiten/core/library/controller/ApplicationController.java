package com.jiten.core.library.controller;

import com.jiten.core.library.model.Book;
import com.jiten.core.library.service.LibraryService;
import com.jiten.core.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class ApplicationController {

    @Autowired
    LibraryService libraryService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(libraryService.getAllBooks());
    }

    @PostMapping(value = "/borrow", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrowBook(@RequestParam String bookName) {
        userService.borrowBook(bookName);
        return ResponseEntity.ok("Success!!");
    }
}
