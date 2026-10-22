package com.kiet.library.repository;

import com.kiet.library.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbc;

    public BookRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<Book> bookMapper=new RowMapper<Book>(){@Override public Book mapRow(ResultSet rs,int rowNum)throws SQLException{

    Book b=new Book();b.setBookId(rs.getInt("book_id"));b.setTitle(rs.getString("title"));b.setAuthor(rs.getString("author"));b.setCategory(rs.getString("category"));b.setPublicationYear(rs.getInt("publication_year"));b.setAvailable(rs.getBoolean("available"));

    return b;}};

    public List<Book> findAll() {
        return jdbc.query(
                "SELECT * FROM books ORDER BY book_id",
                bookMapper);
    }

    public List<Book> findById(int id) {
        return jdbc.query(
                "SELECT * FROM books WHERE book_id = ?",
                bookMapper,
                id);
    }

    public int deleteById(int id) {
        return jdbc.update(
            "DELETE FROM books WHERE book_id = ?",
            id
        );
    }
}```