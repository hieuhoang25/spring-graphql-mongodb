package com.hicode.springgraphqlmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    private  String id;

    private String name;
    @Field(name = "page_count") /** this annotation represent field in document */
    private Integer pageCount;

}
