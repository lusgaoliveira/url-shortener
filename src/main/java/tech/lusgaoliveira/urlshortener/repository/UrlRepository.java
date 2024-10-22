package tech.lusgaoliveira.urlshortener.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.lusgaoliveira.urlshortener.entity.Url;

@Repository
public interface UrlRepository extends CrudRepository<Url, String> {
}
