package com.msta3t.bookstore.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msta3t.bookstore.domain.Book;
import com.msta3t.bookstore.domain.BookRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api/v1/books")
@RestController
public class BookRestController {
    public BookRestController(BookRepository repository) {
        this.repository = repository;
    }

    private BookRepository repository;

    @GetMapping
    public @ResponseBody List<Book> restBookList() {
        return (List<Book>) repository.findAll();
    }

    @GetMapping("/{isbn}")
    public @ResponseBody Book restBookById(@PathVariable("isbn") String isbn) {
        return repository.findById(isbn).orElse(null) ;
    }
}
