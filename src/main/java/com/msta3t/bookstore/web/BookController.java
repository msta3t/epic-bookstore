package com.msta3t.bookstore.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.msta3t.bookstore.domain.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    public BookController(BookRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    private BookRepository repository;
    private CategoryRepository categoryRepository;

    @GetMapping("/index")
    public String getIndex() {
        return "indexPage";
    }

    @GetMapping("/list")
    public String getBookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") String id, Model model) {
        model.addAttribute("book", repository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id, Model model) {
        repository.deleteById(id);
        return "redirect:../list";
    }
}
