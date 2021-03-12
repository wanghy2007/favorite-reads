package com.moonbase.nt.favoritereads.repository;

import com.moonbase.nt.favoritereads.domain.BookAuthor;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bookAuthors", path = "bookAuthors")
public interface BookAuthorRepository extends PagingAndSortingRepository<BookAuthor, Long> {
    
}
