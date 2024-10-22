package tech.lusgaoliveira.urlshortener.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.lusgaoliveira.urlshortener.dto.UrlShorteningRequest;
import tech.lusgaoliveira.urlshortener.dto.UrlShorteningResponse;
import tech.lusgaoliveira.urlshortener.service.UrlService;

@RestController
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping(value = "/shorten_url")
    public ResponseEntity<UrlShorteningResponse> shortenUrl(@RequestBody UrlShorteningRequest url,
                                                            HttpServletRequest request) {
        return urlService.generateShortenUrl(url, request);
    }

    @GetMapping("{id}")
    public ResponseEntity getUrl(@PathVariable("id") String id) {
        return urlService.getFullUrl(id);
    }
}
