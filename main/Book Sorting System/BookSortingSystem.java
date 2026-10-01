import java.util.*;

class Book {
    int bookId;
    String title;
    int pages;

    Book(int bookId, String title, int pages) {
        this.bookId = bookId;
        this.title = title;
        this.pages = pages;
    }

    void display() {
        System.out.println(bookId + "\t" + title + "\t" + pages);
    }
}

public class BookSortingSystem {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(101, "Java Basics", 150));
        books.add(new Book(104, "Data Structures", 150));
        books.add(new Book(103, "Computer Networks", 250));
        books.add(new Book(102, "Operating Systems", 400));

        // Comparator for sorting books
        Collections.sort(books, new Comparator<Book>() {

            @Override
            public int compare(Book b1, Book b2) {

                // Sort by pages in ascending order
                if (b1.pages != b2.pages) {
                    return Integer.compare(b1.pages, b2.pages);
                }

                // If pages are same, sort by title alphabetically
                return b1.title.compareTo(b2.title);
            }
        });

        System.out.println("Book ID\tTitle\t\t\tPages");
        System.out.println("---------------------------------------------");

        for (Book b : books) {
            b.display();
        }
    }
}