package com.msta3t.bookstore;

import com.msta3t.bookstore.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, AppUserRepository appUserRepository) {
        return (args) -> {

            AppUser user1 = appUserRepository.save(new AppUser(
                    "user",
                    "$2a$10$C0dS/zZZEr27qGO5ETSZNexZ0yq2nVJ/wj3Y5fX6UWZ6b68Xe0XNy",
                    "user@example.com",
                    "USER"
            ));

            AppUser user2 = appUserRepository.save(new AppUser(
                    "admin",
                    "$2a$10$C0dS/zZZEr27qGO5ETSZNexZ0yq2nVJ/wj3Y5fX6UWZ6b68Xe0XNy",
                    "admin@example.com",
                    "ADMIN"
            ));

            Category cyber = categoryRepository.save(new Category("Cybersecurity"));
            Category cs = categoryRepository.save(new Category("Computer Science"));
            Category prog = categoryRepository.save(new Category("Programming"));

            bookRepository.save(new Book(
                    "Internet",
                    "Mikko Hyppönen",
                    2021,
                    "978-951-0-46443-4",
                    20.00,
                    cyber
            ));
            bookRepository.save(new Book(
                    "Structure and Interpretation of Computer Programs",
                    "Harold Abelson and Gerald Jay Sussman",
                    1996,
                    "978-0262510875",
                    80,
                    cs
            ));
            bookRepository.save(new Book(
                    "The C Programming Language",
                    "Brian Kernighan & Dennis Ritchie",
                    1988,
                    "978-0131103627",
                    50,
                    prog
            ));
            bookRepository.save(new Book(
                    "Compilers: Principles, Techniques, and Tools",
                    "Alfred Aho",
                    2006,
                    "0-201-10088-6",
                    100,
                    cs
            ));
            bookRepository.save(new Book(
                    "Effective Java",
                    "Joshua Bloch",
                    2001,
                    "978-0201310054",
                    20,
                    prog
            ));
            bookRepository.save(new Book(
                    "SQL and Relational Theory",
                    "C. J. Date",
                    2015,
                    "978-1491941171",
                    30,
                    cs
            ));
        };
    }
}