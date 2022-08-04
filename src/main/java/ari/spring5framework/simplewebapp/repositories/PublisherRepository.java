package ari.spring5framework.simplewebapp.repositories;

import ari.spring5framework.simplewebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
