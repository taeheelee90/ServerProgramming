package HaagaHelia.ServerProgramming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HaagaHelia.ServerProgramming.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Book findBookById(Long id);
}
