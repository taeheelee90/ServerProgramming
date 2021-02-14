package HaagaHelia.ServerProgramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import HaagaHelia.ServerProgramming.domain.Book;

import HaagaHelia.ServerProgramming.repository.BookRepository;


@SpringBootApplication
public class ServerProgrammingApplication {

	private static final Logger log = LoggerFactory.getLogger(ServerProgrammingApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ServerProgrammingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			
			log.info("Save books");
			bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", "123-456", "1929"));
			bookRepository.save(new Book("Annimal Farm", "George Orwell", "456-789", "1945"));
			
		
		};
	}
}
