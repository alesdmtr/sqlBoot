package com.example.demo;

import com.example.demo.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class findBooks implements FindBook {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<Book> findAll() {

        String sql = "SELECT * FROM books";

        return jtm.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book findById(Long id) {
        String sql = "SELECT * FROM books WHERE id = ?";

        return jtm.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void insertBook(String name, String author) {
        //MapSqlParameterSource params = new MapSqlParameterSource();
        String sql = "INSERT INTO books(name, author) VALUES (?, ?)";
        Object[] params = new Object[] {name, author};

        jtm.update(sql, params);
        //params.addValue("firstName", firstName);
        //params.addValue("lastName", lastName);
        //params.addValue("age", age);
        //jdbcTemplate.update(SQL_INSERT_PROFILE, params);
    }
}