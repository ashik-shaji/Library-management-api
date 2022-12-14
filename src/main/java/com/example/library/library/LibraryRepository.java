package com.example.library.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    @Query("SELECT b FROM Library b WHERE b.publisher = ?1")
    Optional<Library> findBookByPublisher(String publisher);
}
