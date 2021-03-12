package com.moonbase.nt.favoritereads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import com.moonbase.nt.favoritereads.domain.Author;
import com.moonbase.nt.favoritereads.domain.Book;
import com.moonbase.nt.favoritereads.repository.AuthorRepository;
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

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author();
        author1.setFirstName("Todd");
        author1.setLastName("Strasser");
        this.authorRepository.save(author1);

        Book book1 = new Book();
        book1.setTitle("Good War.");
        book1.setAuthors(new HashSet<>(Arrays.asList(author1)));
        this.bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("No place");
        book2.setAuthors(new HashSet<>(Arrays.asList(author1)));
        this.bookRepository.save(book2);
    }

    
}
