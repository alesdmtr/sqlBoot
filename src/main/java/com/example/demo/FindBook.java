package com.example.demo;
import com.example.demo.Book;
import java.util.List;

    public interface FindBook {

        List<Book> findAll();
        Book findById(Long id);
    }

