package tech.lusgaoliveira.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.lusgaoliveira.urlshortener.entity.Url;

public interface UrlRepository extends JpaRepository<Url, Long> {
}
