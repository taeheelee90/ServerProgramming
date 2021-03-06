package HaagaHelia.ServerProgramming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import HaagaHelia.ServerProgramming.domain.Book;
import HaagaHelia.ServerProgramming.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/")
public class BookRestController {

	@Autowired
	BookRepository bookRepository;

	// Restful service to get all books
	@RequestMapping(value = "/books")
	public List<Book> bookListRest() {
		return bookRepository.findAll();
	}

	// Restful service to get book by id
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public Book findBookRest(@PathVariable("id") Long bookId) {
		return bookRepository.findBookById(bookId);
	}

	// Restful service to add book
	@PostMapping("/books")
	public Book newBookRest(@RequestBody Book newBook) {
		return bookRepository.save(newBook);
	}

	// Restful service to edit book
	@PutMapping("/books/{id}")
	public Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {

		Book book = bookRepository.findBookById(id);
		if (book != null) {
			book.setTitle(newBook.getTitle());
			book.setIsbn(newBook.getIsbn());
			book.setYear(newBook.getYear());
			book.setAuthor(newBook.getAuthor());
			book.setCategory(newBook.getCategory());
			bookRepository.save(book);
		} else {
			book = bookRepository.save(newBook);
		}
		return book;
	}

	// Restful service to delete book
	@DeleteMapping("/books/{id}")
	void deleteBook(@PathVariable Long id) {
		bookRepository.deleteById(id);
	}
}
