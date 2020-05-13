package com.example.demo;
import com.example.demo.Book;
import java.util.List;

    public interface FindBookInterface {

        List<Book> findAll();
        Book findById(Long id);
        void insertBook(String name, String author);

        void deleteById(long parseLong);
    }

