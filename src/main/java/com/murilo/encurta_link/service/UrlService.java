package com.murilo.encurta_link.service;

import com.murilo.encurta_link.model.Url;
import com.murilo.encurta_link.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    private final UrlRepository repository;
    private final Random random = new Random();

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public Url createShortUrl(String originalUrl){
        Url url = new Url();

        url.setOriginalUrl(originalUrl);
        url.setShortCode(generateShortCode());
        return repository.save(url);
    }

    public Optional<Url> SearchForCode(String shortCode){
        return repository.findByShortCode(shortCode);
    }

    private String generateShortCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            code.append(chars.charAt(random.nextInt(chars.length())));
        }
        return code.toString();
    }

    public List<Url> getAllUrls(){
        return repository.findAll();
    }
}
