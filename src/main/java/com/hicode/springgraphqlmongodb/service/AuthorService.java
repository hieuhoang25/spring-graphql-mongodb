package com.hicode.springgraphqlmongodb.service;

import com.hicode.springgraphqlmongodb.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAll();
    Author getById(String id);

    Author save(Author author);

    Author update(Author author);

    void detele(String id);


}
