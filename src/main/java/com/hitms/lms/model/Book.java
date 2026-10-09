package com.hitms.lms.model;

public class Book {
    private final String title;
    private boolean issued;

    /** Creates an available book with the given title. */
    public Book(String title) {
        this.title = title;
    }

    /** Returns the title of the book. */
    public String getTitle() {
        return title;
    }

    /** Returns true if the book is currently issued. */
    public boolean isIssued() {
        return issued;
    }

    /** Marks the book as issued or available. */
    public void setIssued(boolean issued) {
        this.issued = issued;
    }
}