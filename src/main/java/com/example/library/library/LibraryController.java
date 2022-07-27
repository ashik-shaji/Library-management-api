package com.example.library.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<Library> getBooks() {
        return libraryService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Library book) {
        libraryService.addBook(book);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        libraryService.deleteBook(bookId);
    }

    @PutMapping(path = "{bookId}")
    public void updateBookName(
            @PathVariable("bookId") Long bookId,
            @RequestParam String bookName
    ) {
        libraryService.updateBookName(bookId, bookName);
    }

}
