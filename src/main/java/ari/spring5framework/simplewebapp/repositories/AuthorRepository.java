package ari.spring5framework.simplewebapp.repositories;

import ari.spring5framework.simplewebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
