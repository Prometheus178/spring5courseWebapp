package com.spring5course.repositories;

import com.spring5course.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

}
