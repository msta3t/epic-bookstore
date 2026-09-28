package com.msta3t.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.msta3t.bookstore.domain.BookRepository;

@Controller
public class BookController {
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    private BookRepository repository;

    @GetMapping("/index")
    public String getIndex() {
        return "indexPage";
    }

    @GetMapping("/booklist")
    public String getBookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
}
