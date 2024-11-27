package com.project.ShortenerUrl.service;

import com.project.ShortenerUrl.models.dto.OriginalUrlDto;
import com.project.ShortenerUrl.models.dto.ShortUrl;
import com.project.ShortenerUrl.models.entity.OriginalUrl;
import com.project.ShortenerUrl.repository.UrlRepository;
import com.project.ShortenerUrl.service.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private final ShortUrlGenerate urlGenerate;

    public UrlService(UrlRepository urlRepository, ShortUrlGenerate urlGenerate) {
        this.urlRepository = urlRepository;
        this.urlGenerate = urlGenerate;
    }

    public ShortUrl saveOriginalUrl(OriginalUrlDto urlDto){
        if(urlDto.getOriginalUrl().isEmpty() || urlDto.getExpirationTime().isEmpty() || urlDto.getBase() == null){
            throw new ApiException("not_found", "This url, timestamp or base is empty or not exists.", HttpStatus.NOT_FOUND.value());
        }

        long expiration = Long.parseLong(urlDto.getExpirationTime());

        if (expiration < Instant.now().getEpochSecond()){
            throw new ApiException("conflict", "The url time has been expired", HttpStatus.CONFLICT.value());
        }


        String shortUrl = urlGenerate.generateShortenerUrl(urlDto);
        OriginalUrl url = new OriginalUrl();
        url.setShortenerUrl(shortUrl);
        url.setOriginalUrl(urlDto.getOriginalUrl());
        url.setExpirationTime(urlDto.getExpirationTime());


        if (urlRepository.findByShortenerUrl(shortUrl).isEmpty()){
            urlRepository.save(url);
        }

        return new ShortUrl(shortUrl);
    }

    public OriginalUrl searchUrlByShortUrl(String shortUrl){
        OriginalUrl originalUrl = urlRepository.findByShortenerUrl(shortUrl).orElseThrow(() ->
                new ApiException("not_found", "The url not exists", HttpStatus.NOT_FOUND.value()));

        long expiration = Long.parseLong(originalUrl.getExpirationTime());

        if (expiration < Instant.now().getEpochSecond()){
            urlRepository.delete(originalUrl);
            throw new ApiException("conflict", "This Url time has been expired", HttpStatus.CONFLICT.value());
        }

        return originalUrl;
    }
}
