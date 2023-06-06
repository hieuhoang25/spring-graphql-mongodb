package com.hicode.springgraphqlmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document("author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    private String id;
    @Indexed(unique = true)
    private String firstName;
    private String lastName;
    @DocumentReference(lazy = true) /** [Author] Document reference [Book] Document*/
    private List<Book> book;
}
