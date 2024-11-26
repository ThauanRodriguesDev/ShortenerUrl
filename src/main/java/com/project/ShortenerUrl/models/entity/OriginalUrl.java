package com.project.ShortenerUrl.models.entity;

import com.project.ShortenerUrl.enums.Base;
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
    private String expirationTime;
    private String shortenerUrl;

    public OriginalUrl() {
    }

    public OriginalUrl(String originalUrl, String expirationTime, String shortenerUrl) {
        this.originalUrl = originalUrl;
        this.expirationTime = expirationTime;
        this.shortenerUrl = shortenerUrl;
    }

    public Long getId() {
        return id;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
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
