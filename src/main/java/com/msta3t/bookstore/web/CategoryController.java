package com.msta3t.bookstore.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msta3t.bookstore.domain.Category;
import com.msta3t.bookstore.domain.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {
    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    private CategoryRepository repository;

    @GetMapping("/list")
    public String getCategoryList(Model model) {
        model.addAttribute("categories", repository.findAll());
        model.addAttribute("category", new Category());
        return "categorylist";
    }

    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/save")
    public String saveCategory(Category category) {
        repository.save(category);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category", repository.findById(id));
        return "editcategory";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id, Model model) {
        repository.deleteById(id);
        return "redirect:../list";
    }

}
