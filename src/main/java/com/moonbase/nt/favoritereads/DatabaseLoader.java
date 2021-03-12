package com.moonbase.nt.favoritereads;

import java.util.ArrayList;
import java.util.HashSet;

import com.moonbase.nt.favoritereads.domain.Author;
import com.moonbase.nt.favoritereads.domain.Book;
import com.moonbase.nt.favoritereads.domain.BookAuthor;
import com.moonbase.nt.favoritereads.repository.AuthorRepository;
import com.moonbase.nt.favoritereads.repository.BookAuthorRepository;
import com.moonbase.nt.favoritereads.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book();
        book1.setTitle("Good War.");
        this.bookRepository.save(book1);

        Author author1 = new Author();
        author1.setFirstName("Todd");
        author1.setLastName("Strasser");
        this.authorRepository.save(author1);

        this.bookAuthorRepository.save(BookAuthor.builder().book(book1).author(author1).build());
    }

    
}
