package com.example.library.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getBooks() {
        return libraryRepository.findAll();
    }

    public void addBook(Library book) {
        Optional<Library> bookByPublisher = libraryRepository.findBookByPublisher(book.getPublisher());
        if (bookByPublisher.isPresent()) {
            throw new IllegalStateException("Publisher already present for another book");
        }
        libraryRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        boolean exists = libraryRepository.existsById(bookId);
        if (!exists) {
            throw new IllegalStateException("Book with id " + bookId + " does not exists");
        }
        libraryRepository.deleteById(bookId);
    }


    @Transactional
    public void updateBookName(Long bookId, String bookName) {
        Library book = libraryRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " does not exists"));
        if (bookName != null && bookName.length() > 0 && !Objects.equals(book.getBook(), bookName)) {
            book.setBook(bookName);
        }
    }
}
