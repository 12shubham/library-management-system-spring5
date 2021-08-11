package com.library.management.system.bootstrap;

import com.library.management.system.domain.Author;
import com.library.management.system.domain.Book;
import com.library.management.system.domain.Publisher;
import com.library.management.system.repositories.AuthorRepository;
import com.library.management.system.repositories.BookRepository;
import com.library.management.system.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
// CommandLineRunner to run one time activities
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        Author a1 = new Author("Shubham","Khetan");
        Book b1 = new Book("Autobiography Of A Yogi", "12334");
        Publisher p1 = new Publisher("Paramhansa", "California");
        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);
        b1.setPublisher(p1);
        p1.getBooks().add(b1);
        publisherRepository.save(p1);
        authorRepository.save(a1);
        bookRepository.save(b1);


        Author a2 = new Author("Monisha","Bajaj");
        Book b2 = new Book("My Life, My Rules", "12335");
        Publisher p2 = new Publisher("Yogananda", "India");
        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);
        b2.setPublisher(p2);
        p2.getBooks().add(b2);
        publisherRepository.save(p2);
        authorRepository.save(a2);
        bookRepository.save(b2);

    }
}
