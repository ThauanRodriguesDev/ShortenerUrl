package com.project.ShortenerUrl.models.dto;

public class ShortUrl {
    private final String shortCode;

    public ShortUrl(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getShortCode() {
        return shortCode;
    }
}
