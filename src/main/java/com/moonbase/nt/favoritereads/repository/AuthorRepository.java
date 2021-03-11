package com.moonbase.nt.favoritereads.repository;

import com.moonbase.nt.favoritereads.domain.Author;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
    
}
