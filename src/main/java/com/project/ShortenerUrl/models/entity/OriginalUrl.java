package com.project.ShortenerUrl.models.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "urls_collections")
public class OriginalUrl {
    @Id
    private Long id;

    private String originalUrl;

    private Long ExpirationTime;

    public OriginalUrl() {
    }

    public OriginalUrl(String originalUrl, Long expirationTime) {
        this.originalUrl = originalUrl;
        ExpirationTime = expirationTime;
    }

    public Long getExpirationTime() {
        return ExpirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        ExpirationTime = expirationTime;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
