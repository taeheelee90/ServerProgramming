package HaagaHelia.ServerProgramming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HaagaHelia.ServerProgramming.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String name);
}
