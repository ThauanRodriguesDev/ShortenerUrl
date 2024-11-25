package com.project.ShortenerUrl.models.dto;

public class OriginalUrlDto {
    private Long id;
    private String originalUrl;
    private String expirationTime;

    public OriginalUrlDto() {
    }

    public OriginalUrlDto(String expirationTime, String originalUrl) {
        this.expirationTime = expirationTime;
        this.originalUrl = originalUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
