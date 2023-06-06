package com.hicode.springgraphqlmongodb.repository;

import com.hicode.springgraphqlmongodb.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
