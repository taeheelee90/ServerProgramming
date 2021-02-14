package HaagaHelia.ServerProgramming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import HaagaHelia.ServerProgramming.domain.Book;
import HaagaHelia.ServerProgramming.repository.BookRepository;

@Controller
public class W3Controller {

	@Autowired
	BookRepository bookRepository;

	@GetMapping("books")
	public String booklist(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "books";
	}

	@GetMapping("/book-form")
	public String showBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "addBookForm";
	}

	@PostMapping("/books")
	public String saveBook(Book book, Model model) {
		bookRepository.save(book);
		return "redirect:/books";
	}

	@GetMapping("/delete-book/{id}")
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:/books";
	}

	@GetMapping("/edit-book/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		return "editBookForm";
	}

}
