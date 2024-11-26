package com.project.ShortenerUrl.models.dto;

import java.util.Objects;

public class OriginalUrlDto {
    private Long id;
    private String originalUrl;
    private String expirationTime;
    private Integer base;

    public OriginalUrlDto() {
    }

    public OriginalUrlDto(String expirationTime, String originalUrl, Integer base) {
        this.expirationTime = expirationTime;
        this.originalUrl = originalUrl;
        this.base = base;
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OriginalUrlDto that = (OriginalUrlDto) o;
        return Objects.equals(id, that.id) && Objects.equals(originalUrl, that.originalUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalUrl);
    }
}
