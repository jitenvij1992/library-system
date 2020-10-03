package com.jiten.core.library.service.impl;

import com.jiten.core.library.dao.impl.LibraryRepositoryImpl;
import com.jiten.core.library.model.Book;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LibraryServiceImplTest {

    @InjectMocks
    LibraryServiceImpl bookService;

    @Mock
    LibraryRepositoryImpl bookRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAllGetBooksWhenNull() {
        List<Book> books = new ArrayList<>();
        when(bookRepository.getAllBooks()).thenReturn(books);
        List<Book> bookList = bookService.getAllBooks();
        assertThat(bookList, IsEmptyCollection.empty());
    }

    @Test
    public void testWhenBookIsPresent() {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setName("book2");
        book.setAuthor("author2");
        books.add(book);
        when(bookRepository.getAllBooks()).thenReturn(books);
        List<Book> bookList = bookService.getAllBooks();
        assertThat(bookList, hasSize(1));
        assertThat(bookList, hasItems(books.get(0)));
    }

}