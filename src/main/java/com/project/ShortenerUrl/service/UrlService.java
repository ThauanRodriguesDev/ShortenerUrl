package com.project.ShortenerUrl.service;

import com.project.ShortenerUrl.models.dto.OriginalUrlDto;
import com.project.ShortenerUrl.models.dto.ShortUrl;
import com.project.ShortenerUrl.models.entity.OriginalUrl;
import com.project.ShortenerUrl.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public ShortUrl saveOriginalUrl(OriginalUrlDto urlDto){
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
        return urlRepository.findByShortenerUrl(shortUrl).orElseThrow(RuntimeException::new);
    }
}
