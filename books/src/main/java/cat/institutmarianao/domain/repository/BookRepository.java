package cat.institutmarianao.domain.repository;

import java.util.List;

import cat.institutmarianao.domain.Book;

public interface BookRepository {
    List<Book> getAll(); 
    void add(Book book);
    void update(Book book);
    void delete(String isbn);
    Book get(String isbn);
    List<Book> findByTitle(String title);    
}
