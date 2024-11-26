package com.project.ShortenerUrl.service;

import com.project.ShortenerUrl.enums.Base;
import com.project.ShortenerUrl.models.dto.OriginalUrlDto;
import com.project.ShortenerUrl.service.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlGenerate {
    private String shortUrl;

    public String generateShortenerUrl(OriginalUrlDto originalUrl) {
        if(originalUrl.getBase() != 58 && originalUrl.getBase() != 62){
            throw new ApiException("bad_request", "the base have incorrect value.", HttpStatus.BAD_REQUEST.value());
        }
        switch (originalUrl.getBase()){
            case 58:
               shortUrl = generateChars(originalUrl, Base.BASE58);
               break;
            case 62:
                shortUrl =  generateChars(originalUrl, Base.BASE62);
                break;
        }
        return shortUrl;
    }

    private String generateChars(OriginalUrlDto originalUrl,Base base){
        int hash =  originalUrl.hashCode();
        if(hash < 0){
           hash = hash * -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int valueChar;
        while(hash > 0){
            valueChar = hash % base.NUM_BASE;
            hash /= base.NUM_BASE;
            stringBuilder.append(base.BASE.charAt(valueChar));
        }
        return stringBuilder.toString();
    }
}
