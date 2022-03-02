package com.in28minutes.springboot.basics.springbootin10steps;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return Arrays.asList(
				new Book(1l, "Mastering Spring 5.2", "Isthiyak Saalim M"), 
				new Book(2l, "Mastering Spring Boot", "Nawrin Banu S"), 
				new Book(3l, "Mastering Python", "Lorem Ipsum M"));
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable(name = "id") long id) {
		return new Book(2l, "Mastering Spring Boot", "Nawrin Banu S");
	}
	
}
