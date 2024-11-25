package com.project.ShortenerUrl.controller;

import com.project.ShortenerUrl.models.dto.OriginalUrlDto;
import com.project.ShortenerUrl.models.dto.ShortUrl;
import com.project.ShortenerUrl.models.entity.OriginalUrl;
import com.project.ShortenerUrl.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public ResponseEntity<ShortUrl> saveUrl(@RequestBody OriginalUrlDto url){
        ShortUrl shortUrl = urlService.saveOriginalUrl(url);
        return ResponseEntity.status(HttpStatus.CREATED).body(shortUrl);
    }
}
