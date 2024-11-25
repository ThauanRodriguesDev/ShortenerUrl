package com.project.ShortenerUrl.service;

import com.project.ShortenerUrl.models.dto.OriginalUrlDto;
import com.project.ShortenerUrl.models.dto.ShortUrl;
import com.project.ShortenerUrl.models.entity.OriginalUrl;
import com.project.ShortenerUrl.repository.UrlRepository;
import com.project.ShortenerUrl.service.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public ShortUrl saveOriginalUrl(OriginalUrlDto urlDto){
        if(urlDto.getOriginalUrl().isEmpty() || urlDto.getExpirationTime().isEmpty()){
            throw new ApiException("not_found", "This url or timestamp is empty or not exists.", HttpStatus.NOT_FOUND.value());
        }

        long expiration = Long.parseLong(urlDto.getExpirationTime());

        if (expiration < Instant.now().getEpochSecond()){
            throw new ApiException("conflict", "The url time has been expired", HttpStatus.CONFLICT.value());
        }

        UUID uuid = UUID.randomUUID();
        String shortUrl = uuid.toString().substring(0,8);

        OriginalUrl url = new OriginalUrl();
        url.setShortenerUrl(shortUrl);
        url.setOriginalUrl(urlDto.getOriginalUrl());
        url.setExpirationTime(urlDto.getExpirationTime());

        urlRepository.save(url);

        return new ShortUrl(shortUrl);
    }

    public OriginalUrl searchUrlByShortUrl(String shortUrl){
        OriginalUrl originalUrl = urlRepository.findByShortenerUrl(shortUrl).orElseThrow(() ->
                new ApiException("not_found", "The url not exists", HttpStatus.NOT_FOUND.value()));

        long expiration = Long.parseLong(originalUrl.getExpirationTime());

        if (expiration < Instant.now().getEpochSecond()){
            throw new ApiException("conflict", "This Url time has been expired", HttpStatus.CONFLICT.value());
        }

        return originalUrl;
    }
}
