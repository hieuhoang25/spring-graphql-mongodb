package com.hicode.springgraphqlmongodb;

import com.hicode.springgraphqlmongodb.model.Author;
import com.hicode.springgraphqlmongodb.model.Book;
import com.hicode.springgraphqlmongodb.repository.AuthorRepository;
import com.hicode.springgraphqlmongodb.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringGraphqlMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlMongodbApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(AuthorRepository authorRepo, BookRepository bookRep){
		return args -> {
			Book book1 = new Book(null, "Clean Book", 100);
			Book book2 = new Book(null, "System Design 1", 190);
			Book book3 = new Book(null, "System Design 2", 190);
			Author author1 = new Author(null, "HiCode", "Hieu",List.of(bookRep.save(book1)));
			Author author2 = new Author(null, "Alex", "Hicode",List.of(bookRep.save(book2), bookRep.save(book3)));
			authorRepo.save(author1);
			authorRepo.save(author2);
		};
	}
}
