package com.project.ShortenerUrl.repository;

import com.project.ShortenerUrl.models.entity.OriginalUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<OriginalUrl, Long> {
    Optional<OriginalUrl> findByShortenerUrl(String shortenerUrl);
}
