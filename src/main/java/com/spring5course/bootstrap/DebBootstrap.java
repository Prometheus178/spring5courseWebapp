package com.spring5course.bootstrap;

import com.spring5course.model.Author;
import com.spring5course.model.Book;
import com.spring5course.model.Publisher;
import com.spring5course.repositories.AuthorRepository;
import com.spring5course.repositories.BookRepository;
import com.spring5course.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DebBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher publisher1 = new Publisher();
        publisher1.setName("foo");
        publisherRepository.save(publisher1);

        Author eric = new Author("Eric", "Robbertson");
        Book ddd = new Book("domain driven design", "233", publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher publisher2 = new Publisher();
        publisher1.setName("foo2");
        publisherRepository.save(publisher2);

        Author merch = new Author("Merch", "Bertson");
        Book aaa = new Book("amain adriven aesign", "123", publisher2);
        eric.getBooks().add(aaa);
        ddd.getAuthors().add(merch);
        authorRepository.save(merch);
        bookRepository.save(aaa);
    }
}
