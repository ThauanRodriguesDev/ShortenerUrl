package com.project.ShortenerUrl.controller;

import com.project.ShortenerUrl.models.dto.OriginalUrlDto;
import com.project.ShortenerUrl.models.dto.ShortUrl;
import com.project.ShortenerUrl.models.entity.OriginalUrl;
import com.project.ShortenerUrl.service.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/api/url")
    public ResponseEntity<ShortUrl> saveUrl(@RequestBody OriginalUrlDto url){
        ShortUrl shortUrl = urlService.saveOriginalUrl(url);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{url}")
                .buildAndExpand(url.getId()).toUri();
        return ResponseEntity.created(uri).body(shortUrl);
    }

    @GetMapping("/{url}")
    public ResponseEntity<Void> redirectUrl(@PathVariable String url) {
        OriginalUrl originalUrl = urlService.searchUrlByShortUrl(url);
        if (originalUrl != null) {

            if (originalUrl.getOriginalUrl().contains("localhost:8080/" + url)) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build();
            }
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", originalUrl.getOriginalUrl());
            return new ResponseEntity<>(httpHeaders, HttpStatus.FOUND);
        }
        return ResponseEntity.notFound().build();
    }
}
