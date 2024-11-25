package com.project.ShortenerUrl.repository;

import com.project.ShortenerUrl.models.entity.OriginalUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<OriginalUrl, Long> {
}
