package tech.lusgaoliveira.urlshortener.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.lusgaoliveira.urlshortener.dto.UrlShorteningRequest;
import tech.lusgaoliveira.urlshortener.dto.UrlShorteningResponse;
import tech.lusgaoliveira.urlshortener.entity.Url;
import tech.lusgaoliveira.urlshortener.repository.UrlRepository;

import java.net.URI;
import java.util.Optional;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public ResponseEntity<UrlShorteningResponse> generateShortenUrl(UrlShorteningRequest url,
                                                                    HttpServletRequest request) {
        String id;
        do {
            id = randomShortening();
        }while (urlRepository.existsById(id));
        Long timeToExpire = 60L;

        Url urlToSave = new Url(id, url.url(), timeToExpire);

        urlRepository.save(urlToSave);
        var redirect = request.getRequestURL().toString().replace("shorten_url", id);
        return ResponseEntity.ok(new UrlShorteningResponse(redirect));
    }

    public ResponseEntity getFullUrl(String id) {
        Optional<Url> fullUrlOptional = urlRepository.findById(id);
        if (fullUrlOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        String fullUrl = fullUrlOptional.get().getFullUrl();

        System.out.println("fullurl: " + fullUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(fullUrl));
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();

    }
    private String randomShortening() {
        var possibilities = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var stringLength = (int) (Math.random() * (10 - 5 + 1)) + 5;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringLength; i++) {
            var randomIndex = (int) (Math.random() * possibilities.length());
            result.append(possibilities.charAt(randomIndex));
        }
        return result.toString();
    }
}
