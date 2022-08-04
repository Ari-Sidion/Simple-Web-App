package ari.spring5framework.simplewebapp.bootstrap;

import ari.spring5framework.simplewebapp.domain.Author;
import ari.spring5framework.simplewebapp.domain.Book;
import ari.spring5framework.simplewebapp.domain.Publisher;
import ari.spring5framework.simplewebapp.repositories.AuthorRepository;
import ari.spring5framework.simplewebapp.repositories.BookRepository;
import ari.spring5framework.simplewebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher publisher = new Publisher("Furiosa", "Albi", "City", "11111");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisher.getBooks().add(ddd);
        this.authorRepository.save(eric);
        this.bookRepository.save(ddd);
        this.publisherRepository.save(publisher);
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Dev without EJB", "3939393939");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);
        this.authorRepository.save(rod);
        this.bookRepository.save(noEJB);
        this.publisherRepository.save(publisher);
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + this.bookRepository.count());
        Publisher p1 = new Publisher("Name1", "Scheitzerstr.", "Badenbaden", "77777");
        Publisher p2 = new Publisher("Name2", "AlbAlb", "CalbCalb", "NarbNarb");
        this.publisherRepository.save(p1);
        this.publisherRepository.save(p2);
        System.out.println("Number of Books of Publisher: " + publisher.getBooks().size());
    }
}
