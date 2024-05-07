package cat.institutmarianao.domain.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cat.institutmarianao.domain.Book;
import cat.institutmarianao.domain.repository.BookRepository;
import jakarta.ejb.Singleton;

@Singleton
public class InMemoryBookRepository implements BookRepository {

	private final Map<String, Book> shows = new HashMap<>();

	public InMemoryBookRepository() {
		Book first = new Book("9788425343537", "Ildefonso Falcones", "La catedral del mar");
		Book second = new Book("9788467009477", "Jose Maria Peridis Perez", "La luz y el misterio de las catedrales");

		shows.put("9788425343537", first);
		shows.put("9788467009477", second);
	}

	@Override
	public List<Book> getAll() {
		return new ArrayList<>(shows.values());
	}

	@Override
	public void add(Book book) {
		shows.put(book.getIsbn(), book);
	}

	@Override
	public void update(Book book) {
		if (shows.containsKey(book.getIsbn())) {
			Book toUpdate = shows.get(book.getIsbn());
			toUpdate.setAuthor(book.getAuthor());
			toUpdate.setTitle(book.getTitle());
		}
	}

	@Override
	public void delete(String isbn) {
		if (shows.containsKey(isbn)) {
			shows.remove(isbn);
		}
	}

	@Override
	public Book get(String isbn) {
		return shows.get(isbn);
	}

	@Override
	public List<Book> findByTitle(String title) {
		List<Book> result = new ArrayList<>();
		for (Book item : shows.values()) {
			if (item.getTitle().toUpperCase().contains(title.toUpperCase())) {
				result.add(item);
			}
		}
		return result;
	}
}
