package com.example.library.library;

import javax.persistence.*;

@Entity
@Table
public class Library {
    @Id
    @SequenceGenerator(
            name = "library_sequence",
            sequenceName = "library_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "library_sequence"
    )
    private Long id;
    private String book;
    private String author;
    private String publisher;

    public Library() {
    }

    public Library(Long id,
                   String book,
                   String author,
                   String publisher) {
        this.id = id;
        this.book = book;
        this.author = author;
        this.publisher = publisher;
    }

    public Library(String book,
                   String author,
                   String publisher) {
        this.book = book;
        this.author = author;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", book='" + book + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}


//