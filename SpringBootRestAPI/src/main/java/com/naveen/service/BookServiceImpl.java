package com.naveen.service;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.naveen.modal.Book;

@Service
public class BookServiceImpl implements BookService {

	HashSet<Book> bookList = new HashSet<>();

	@Override
	public HashSet<Book> findAllBooks() {

		if (bookList.isEmpty()) {
			bookList.add(new Book(1, "Java", "Class"));
			bookList.add(new Book(2, "C++", "Structure"));
			bookList.add(new Book(3, "C", "Pointers"));
			return bookList;
		} else
			return bookList;
	}

	@Override
	public Book findBookById(long id) {
		Book book = bookList.stream().filter(b -> b.getId() == id).findAny().orElse(null);
		return book;
	}

	@Override
	public HashSet<Book> addBook(Book book) {
		bookList.add(book);
		return bookList;
	}

	@Override
	public HashSet<Book> deleteBookByName(String name) {
		Book book = bookList.stream().filter(b -> b.getName().equals(name)).findAny().orElse(null);
		bookList.remove(book);
		return bookList;
	}

	@Override
	public void deleteAllBooks() {
		bookList.clear();
	}

	@Override
	public HashSet<Book> deleteBookById(long id) {
		Book book=bookList.stream().filter(b->b.getId()==id).findAny().orElse(null);
		bookList.remove(book);
		return bookList;
	}

}
