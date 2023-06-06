package com.hicode.springgraphqlmongodb.repository;

import com.hicode.springgraphqlmongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
