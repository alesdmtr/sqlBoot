package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class controller {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private findBooks bookService;
    @RequestMapping("/books")
    public List<Book> findCities() {
        return bookService.findAll();
    }
    @RequestMapping("/books/getBook?bookId={bookId}")
    public Book findCity(@PathVariable Long bookId) {

        return bookService.findById(bookId);
    }
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
    @RequestMapping(value = "/controller", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity sendViaResponseEntity() {
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
}