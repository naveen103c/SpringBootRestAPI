package com.naveen.service;

import java.util.HashSet;

import com.naveen.modal.Book;

public interface BookService {
	HashSet<Book> findAllBooks();

	Book findBookById(long id);

	HashSet<Book> addBook(Book book);

	HashSet<Book> deleteBookByName(String name);

	HashSet<Book> deleteBookById(long id);

	void deleteAllBooks();
}
