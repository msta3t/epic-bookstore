package com.msta3t.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.msta3t.bookstore.domain.Book;
import com.msta3t.bookstore.domain.BookRepository;
import com.msta3t.bookstore.domain.Category;
import com.msta3t.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
			categoryRepository.save(new Category("Cybersecurity"));
			categoryRepository.save(new Category("Computer Science"));
			categoryRepository.save(new Category("Programming"));
			
			repository.save(new Book("Internet", "Mikko Hyppönen", 2021, "978-951-0-46443-4", 20.00));
			repository.save(new Book("Structure and Interpretation of Computer Programs", "Harold Abelson and Gerald Jay Sussman", 1996, "978-0262510875", 80));
			repository.save(new Book("The C Programming Language", "Brian Kernighan & Dennis Ritchie", 1988, "978-0131103627", 50));
			repository.save(new Book("Compilers: Principles, Techniques, and Tools", "Alfred Aho", 2006, "0-201-10088-6", 100));
			repository.save(new Book("Effective Java", "Joshua Bloch", 2001, "978-0201310054", 20));
			repository.save(new Book("SQL and Relational Theory", "C. J. Date", 2015, "978-1491941171", 30));
		};
	}

}