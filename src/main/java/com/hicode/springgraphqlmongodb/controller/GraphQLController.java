package com.hicode.springgraphqlmongodb.controller;

import com.hicode.springgraphqlmongodb.model.Author;
import com.hicode.springgraphqlmongodb.model.Book;
import com.hicode.springgraphqlmongodb.service.AuthorService;
import com.hicode.springgraphqlmongodb.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

/**
 *
 * */
@Controller
@AllArgsConstructor
public class GraphQLController {

    private AuthorService authorService;
    private BookService bookService;
   /**
    * If you provide name of query mapping so you can change the name of funtion don't like it
    * */
    @QueryMapping(name = "authors")
    public Iterable<Author> getAuthors(){
        return authorService.getAll();
    }
    /**
     * If you don't provide name of query mapping so you must declare  the name of funtion like the name of query
     * */
    @QueryMapping
    public Author author(@Argument String id){
        return  authorService.getById(id);
    }

    @SchemaMapping
    public Book book(String id){
        return bookService.getById(id);
    }



}
