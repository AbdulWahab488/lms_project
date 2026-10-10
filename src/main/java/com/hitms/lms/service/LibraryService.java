package com.hitms.lms.service;

import com.hitms.lms.model.Book;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private final List<Book> books = new ArrayList<>();

    /** Adds a new book with the given title to the library. */
    public void addBook(String title) {
        books.add(new Book(title));
    }

    /**
     * Issues one copy of the given title from the catalogue; returns false
     * if the title is invalid or no copy is available.
     */
    public boolean issueBook(String title) {
        if (title == null || title.isBlank()) {
            return false;
        }
        Book book = findBook(title);
        if (book == null || book.isIssued()) {
            return false;
        }
        book.setIssued(true);
        return true;
    }

    /** Returns a book; returns true if it existed and was issued. */
    public boolean returnBook(String title) {
        Book book = findBook(title);
        if (book == null || !book.isIssued()) {
            return false;
        }
        book.setIssued(false);
        return true;
    }

    /** Returns the total number of books in the library. */
    public int countBooks() {
        return books.size();
    }

    /** Returns true if the book exists and is not currently issued. */
    public boolean isBookAvailable(String title) {
        Book book = findBook(title);
        return book != null && !book.isIssued();
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}