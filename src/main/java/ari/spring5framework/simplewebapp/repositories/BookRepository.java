package ari.spring5framework.simplewebapp.repositories;

import ari.spring5framework.simplewebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
