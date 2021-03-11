package com.moonbase.nt.favoritereads;

import com.moonbase.nt.favoritereads.domain.Book;
import com.moonbase.nt.favoritereads.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Autowired
    public DatabaseLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        {
            Book book = new Book();
            book.setTitle("Good riddance");
            book.setAuthor("Lipman");
            this.bookRepository.save(book);
        }
    }

    
}
