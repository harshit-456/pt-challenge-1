package ptch.ptch1;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    boolean addBook(Book newBook);
    boolean deleteBook(Long id);
    Book getBookById(Long id);
}
