
package com.kiet.library.service;

import com.kiet.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(201, "Effective Java",
                "Joshua Bloch", "Programming", 2018, true));

        books.add(new Book(202, "Clean Code",
                "Robert C. Martin", "Programming", 2008, true));

        books.add(new Book(203, "The Alchemist",
                "Paulo Coelho", "Fiction", 1988, false));

        books.add(new Book(204, "Introduction to Algorithms",
                "Thomas H. Cormen", "Computer Science", 2022, true));

        books.add(new Book(205, "Python Crash Course",
                "Eric Matthes", "Programming", 2021, true));
    }

    // Retrieve all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // Retrieve a book by ID
    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    // Add a new book
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    // Update an existing book
    public Book updateBook(int bookId, Book updatedBook) {
        Book existingBook = getBookById(bookId);

        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setCategory(updatedBook.getCategory());
            existingBook.setPublicationYear(
                    updatedBook.getPublicationYear());
            existingBook.setAvailable(updatedBook.isAvailable());
        }

        return existingBook;
    }

    // Delete a book
    public boolean deleteBook(int bookId) {
        Book book = getBookById(bookId);

        if (book != null) {
            books.remove(book);
            return true;
        }

        return false;
    }

    // Search books by category
    public List<Book> searchByCategory(String category) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getCategory() != null
                    && category != null
                    && book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }

        return result;
    }

    // Find books published from a specified year onward
    public List<Book> findPublishedFromYear(int fromYear) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getPublicationYear() >= fromYear) {
                result.add(book);
            }
        }

        return result;
    }
}
