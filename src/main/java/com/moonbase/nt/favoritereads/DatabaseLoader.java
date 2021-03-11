package com.moonbase.nt.favoritereads;

import java.util.ArrayList;

import com.moonbase.nt.favoritereads.domain.Author;
import com.moonbase.nt.favoritereads.domain.Book;
import com.moonbase.nt.favoritereads.repository.AuthorRepository;
import com.moonbase.nt.favoritereads.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public DatabaseLoader(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        {
            Book book = new Book();
            book.setTitle("Good riddance");
            this.bookRepository.save(book);
            {
                Author author = new Author();
                author.setFirstName("Todd");
                author.setLastName("Strasser");
                author.setBook(book);
                this.authorRepository.save(author);
            }
        }
    }

    
}
