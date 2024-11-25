package com.project.ShortenerUrl.models.dto;

public class OriginalUrlDto {
    private String originalUrl;
    private Long expirationTime;

    public OriginalUrlDto() {
    }

    public OriginalUrlDto(Long expirationTime, String originalUrl) {
        this.expirationTime = expirationTime;
        this.originalUrl = originalUrl;
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
}
