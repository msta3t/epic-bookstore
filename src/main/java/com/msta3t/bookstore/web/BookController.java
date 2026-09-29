package com.msta3t.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.msta3t.bookstore.domain.*;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") String id, Model model) {
        model.addAttribute("book", repository.findById(id));
        return "editbook";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id, Model model) {
        repository.deleteById(id);
        return "redirect:../booklist";
    }
}
