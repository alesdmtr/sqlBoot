package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/")
public class controller {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private findBooks bookService;
    @RequestMapping("/books")
    public List<Book> findBooks() {
        String error = "Malformed JSON request";
        return bookService.findAll();
    }
    @RequestMapping(value="/books/getBook", method = RequestMethod.GET)
    public Book findBook(@RequestParam("bookId") String bookId) {
        return bookService.findById(Long.parseLong(bookId));
    }

    @RequestMapping(value = "/books/addbook", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity sendViaResponseEntity() {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody Book book) {
        bookService.insertBook(book.getName(), book.getAuthor());
    }

}