package com.murilo.encurta_link.controller;


import com.murilo.encurta_link.model.Url;
import com.murilo.encurta_link.service.UrlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@Tag(name = "Encurtador de URLs", description = "API simples para criar, listar e redirecionar URLs curtas")
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @Operation(summary = "Cria uma URL curta")
    @PostMapping("/encurtar")
    public Url shorten(@RequestBody Url url){
        return service.createShortUrl(url.getOriginalUrl());
    }

    @Operation(summary = "Redireciona para URL original usando o código curto (não testável no Swagger)")
    @GetMapping("/{code}")
    public RedirectView redirect(@PathVariable String code) {
        Url url = service.SearchForCode(code).orElse(null);
        if (url == null) {
            return new RedirectView("/erro");
        }
        return new RedirectView(url.getOriginalUrl());
    }

    @Operation(summary = "Lista todas as URLs curtas criadas")
    @GetMapping("/urls")
    public List<Url> getAllUrls(){
        return service.getAllUrls();
    }
}
