package com.naveen.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.naveen.modal.Book;
import com.naveen.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookservice;

	@GetMapping("/")
	public ModelAndView HomePage() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@GetMapping("/book")
	public HashSet<Book> findAllBooks() {
		return bookservice.findAllBooks();
	}

	@GetMapping("/{id}")
	public Book findBookById(@PathVariable("id") long id) {
		return bookservice.findBookById(id);
	}

	@PostMapping("/addBook")
	public HashSet<Book> addBook(@RequestBody Book book) {
		bookservice.addBook(book);
		return bookservice.findAllBooks();
	}

	@GetMapping("/delete/{id}")
	public HashSet<Book> deleteBookById(@PathVariable("id") long id) {
		bookservice.deleteBookById(id);
		return bookservice.findAllBooks();
	}
	@GetMapping("/deleteBook/{name}")
	public HashSet<Book> deleteBookByName(@PathVariable("name") String name) {
		bookservice.deleteBookByName(name);
		return bookservice.findAllBooks();
	}

	@GetMapping("/delete")
	public void deleteAllBooks() {
		bookservice.deleteAllBooks();
	}

}
