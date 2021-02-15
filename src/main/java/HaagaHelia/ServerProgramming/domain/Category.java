package HaagaHelia.ServerProgramming.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="category")
	private List<Book> books = new ArrayList<>();	
	
	public Category() {
		super();
	}

	public Category(String name) {
		super();		
		this.name = name;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
		
}
