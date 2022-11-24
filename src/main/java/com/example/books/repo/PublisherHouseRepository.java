package com.example.books.repo;

import com.example.books.models.PublisherHouse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublisherHouseRepository extends CrudRepository<PublisherHouse, Long> {
    List<PublisherHouse> findByName(String name); // точный поиск
    List<PublisherHouse> findByNameContains (String name); //поиск по совпадению символа
}

