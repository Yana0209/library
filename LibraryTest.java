package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

// todo: library management program
// create class Book with properties of books
class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    // create a class constructor
    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }
    // declare methods to get values of book properties
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
// create class library
class Library {
    // create list of books in the library
    private ArrayList<Book> books = new ArrayList<>();
    // this method added the book to the list of books in the library
    public void addBook(Book book) {
        books.add(book);
    }
    // returns a list of all books in the library
    public ArrayList<Book> getAllBooks() {
        return books;
    }
    // this method searches a book by name in the list of books
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    // delete a book with given ISBN number
    public boolean removeBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }
}
// create class to test the program
public class LibraryTest {

    private Library library;
    private Book book;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book = new Book("Java Programming", "John Smith", "1234567890", 2021);
    }

    @Test
    public void testAddBook() {
        library.addBook(book);
        assertEquals(1, library.getAllBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        library.addBook(book);
        Book foundBook = library.findBookByTitle("Java Programming");
        assertNotNull(foundBook);
        assertEquals("Java Programming", foundBook.getTitle());
    }

    @Test
    public void testRemoveBookByISBN() {
        library.addBook(book);
        boolean removed = library.removeBookByISBN("1234567890");
        assertTrue(removed);
        assertEquals(0, library.getAllBooks().size());
    }

    @Test
    public void testRemoveNonExistentBook() {
        boolean removed = library.removeBookByISBN("9876543210");
        assertFalse(removed);
    }
}
