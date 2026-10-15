
package com.kiet.library.controller;

import com.kiet.library.model.Book;
import com.kiet.library.service.BookService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET /books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // GET /books/{bookId}
    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(
            @PathVariable int bookId) {

        Book book = bookService.getBookById(bookId);

        if (book == null) {
            return notFound("Book not found");
        }

        return ResponseEntity.ok(book);
    }

    // POST /books
    @PostMapping
    public ResponseEntity<Book> addBook(
            @RequestBody Book book) {

        Book addedBook = bookService.addBook(book);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addedBook);
    }

    // PUT /books/{bookId}
    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateBook(
            @PathVariable int bookId,
            @RequestBody Book updatedBook) {

        Book book = bookService.updateBook(bookId, updatedBook);

        if (book == null) {
            return notFound("Book not found");
        }

        return ResponseEntity.ok(book);
    }

    // DELETE /books/{bookId}
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Map<String, String>> deleteBook(
            @PathVariable int bookId) {

        boolean deleted = bookService.deleteBook(bookId);

        if (!deleted) {
            return messageResponse(
                    HttpStatus.NOT_FOUND, "Book not found");
        }

        return messageResponse(
                HttpStatus.OK, "Book deleted successfully");
    }

    // GET /books/search?category=Programming
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByCategory(
            @RequestParam String category) {

        List<Book> result =
                bookService.searchByCategory(category);

        return ResponseEntity.ok(result);
    }

    // GET /books/published?fromYear=2018
    @GetMapping("/published")
    public ResponseEntity<List<Book>> findPublishedFromYear(
            @RequestParam int fromYear) {

        List<Book> result =
                bookService.findPublishedFromYear(fromYear);

        return ResponseEntity.ok(result);
    }

    // Helper method for 404 responses
    private ResponseEntity<Map<String, String>> notFound(
            String message) {

        return messageResponse(HttpStatus.NOT_FOUND, message);
    }

    private ResponseEntity<Map<String, String>> messageResponse(
            HttpStatus status, String message) {

        Map<String, String> response = new HashMap<>();
        response.put("message", message);

        return ResponseEntity.status(status).body(response);
    }
}
