package com.example.books.repo;

import com.example.books.models.Books;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepository extends CrudRepository<Books, Long> {
    List<Books> findByAutor(String autor); // точный поиск

}
