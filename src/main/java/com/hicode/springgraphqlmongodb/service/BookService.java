package com.hicode.springgraphqlmongodb.service;

import com.hicode.springgraphqlmongodb.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();
    Book getById(String id);

    Book save(Book book);

    Book update(Book book);

    void delete(String id) ;
}
