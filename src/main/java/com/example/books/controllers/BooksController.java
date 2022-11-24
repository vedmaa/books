package com.example.books.controllers;

import com.example.books.models.Books;
import com.example.books.models.PublisherHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.books.repo.BooksRepository;
import com.example.books.repo.PublisherHouseRepository;

import java.util.List;

@Controller
public class BooksController {

   @Autowired
   private BooksRepository booksRepository;
    @GetMapping("/books")
    public String booksMain(Model model) {
        Iterable<Books> books = booksRepository.findAll();
        model.addAttribute("books", books);
        return "Books/main";
    }

    @GetMapping("/books/add")
    public String bookAdd(Model model)
    {
        return "Books/add";
    }

    @PostMapping("/books/add")
    public String bookAdd(@RequestParam String name,
                          @RequestParam String autor,
                          @RequestParam String date,
                          @RequestParam String publishing_house,
                          @RequestParam double price,
                          Model model)
    {
        Books books = new Books(name, autor, date, publishing_house, price);
        booksRepository.save(books);
        return "redirect:/books";
    }

    @GetMapping("/books/filter")
    public String booksFilter(Model model)
    {
        return "Books/filter";
    }

    @PostMapping("/books/filter/result")
    public String booksResult(@RequestParam String autor, Model model)
    {
        List<Books> result = booksRepository.findByAutor(autor);
        model.addAttribute("result", result);
        return "Books/filter";
    }

    @PostMapping("/books/filter/allResult")
    public String booksAllFilterResult(
            @RequestParam String autor,
            Model model
    ) {
        List<Books> result = booksRepository.findByAutor(autor);
        model.addAttribute("result", result);
        return "Books/filter";
    }

    @Autowired
    private PublisherHouseRepository publisherRepository;
    @GetMapping("/publisher")
    public String publisherMain(Model model) {
        Iterable<PublisherHouse> publisherHouses = publisherRepository.findAll();
        model.addAttribute("publisher", publisherHouses);
        return "Publisher/main";
    }

    @GetMapping("/publisher/add")
    public String publisherAdd(Model model)
    {
        return "Publisher/add";
    }

    @PostMapping("/publisher/add")
    public String publisherAdd(@RequestParam String name,
                          @RequestParam Integer opening_year,
                          @RequestParam String name_director,
                          @RequestParam Boolean open_now,
                          @RequestParam double share_price,
                          Model model)
    {
        PublisherHouse publisherHouse = new PublisherHouse(name, opening_year, name_director, open_now, share_price);
        publisherRepository.save(publisherHouse);
        return "redirect:/publisher";
    }

    @GetMapping("/publisher/filter")
    public String publisherFilter(Model model)
    {
        return "Publisher/filter";
    }

    @PostMapping("/publisher/filter/result")
    public String publisherResult(@RequestParam String name, Model model)
    {
        List<PublisherHouse> result = publisherRepository.findByName(name);
        model.addAttribute("result", result);
        return "Publisher/filter";
    }

    @PostMapping("/publisher/filter/allResult")
    public String publisherAllFilterResult(
            @RequestParam String name,
            Model model
    ) {
        List<PublisherHouse> result = publisherRepository.findByName(name);
        model.addAttribute("result", result);
        return "Publisher/filter";
    }
}
