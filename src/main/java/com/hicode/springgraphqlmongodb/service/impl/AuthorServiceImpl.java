package com.hicode.springgraphqlmongodb.service.impl;

import com.hicode.springgraphqlmongodb.model.Author;
import com.hicode.springgraphqlmongodb.repository.AuthorRepository;
import com.hicode.springgraphqlmongodb.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(String id) {
       Optional<Author> author = authorRepository.findById(id);
        return author.orElseThrow(() -> new RuntimeException("This book is not present!"));
    }

    @Override
    public Author save(Author author) {
        return authorRepository.insert(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void detele(String id) {
        authorRepository.delete(getById(id));
    }
}
