package ptch.ptch1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listBooks() { //method to List all Books(Feature-1)
        return bookService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book newBook) //method to Add book to library; (Feature-2)
    {
        boolean success = bookService.addBook(newBook);
        if (success) {
            return ResponseEntity.ok("Book has been added successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid book information. Book addition failed!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        boolean success = bookService.deleteBook(id);
        if (success) {
            return ResponseEntity.ok("Book has been deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}