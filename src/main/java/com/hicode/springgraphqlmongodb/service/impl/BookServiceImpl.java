package com.hicode.springgraphqlmongodb.service.impl;

import com.hicode.springgraphqlmongodb.model.Book;
import com.hicode.springgraphqlmongodb.repository.BookRepository;
import com.hicode.springgraphqlmongodb.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(String id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        return bookOpt.orElseThrow(()->  new RuntimeException("This book is not present!"));
    }

    @Override
    public Book save(Book book) {
        return bookRepository.insert(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(String id) {
        bookRepository.delete(getById(id));
    }
}
