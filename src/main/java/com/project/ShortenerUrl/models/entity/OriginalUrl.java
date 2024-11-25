package com.project.ShortenerUrl.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OriginalUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalUrl;
    private Long expirationTime;
    private String shortenerUrl;

    public OriginalUrl() {
    }

    public OriginalUrl(String originalUrl, Long expirationTime, String shortnerUrl) {
        this.originalUrl = originalUrl;
        this.expirationTime = expirationTime;
        this.shortenerUrl = shortnerUrl;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortenerUrl() {
        return shortenerUrl;
    }

    public void setShortenerUrl(String shortnerUrl) {
        this.shortenerUrl = shortnerUrl;
    }
}
