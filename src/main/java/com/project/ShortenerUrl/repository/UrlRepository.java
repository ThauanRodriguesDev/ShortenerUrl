package com.project.ShortenerUrl.repository;

import com.project.ShortenerUrl.models.entity.OriginalUrl;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<OriginalUrl, String> {
}
