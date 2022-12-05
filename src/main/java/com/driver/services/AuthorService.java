package com.driver.services;

import com.driver.models.Author;
import com.driver.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AuthorService {


    @Autowired
    AuthorRepository authorRepository1;

    public void create(Author author){
           authorRepository1.save(author);
    }
    public List<Author> get_author()
    {
        List<Author> list = authorRepository1.findAll();
        return list;
    }

}
