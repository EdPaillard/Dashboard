package com.hachehorde.api.service;
//import com.hachehorde.api.controller.HtmlController;
//import com.hachehorde.api.controller.WidgetController;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// spotify demande une gestion des tokens, à voir si ca peut passer? 
@RestController
public class DeezerService {

    // private WidgetController widgetController = new WidgetController();
    // private HtmlController htmlController;

    public String Song(String artist) {
        String link = "https://api.deezer.com/search?q=" + artist;

        // Long userId = htmlController.getIdUser();
        // widgetController.saveDWidget(link, userId);

        RestTemplate restTemplate = new RestTemplate();
        String songs = restTemplate.getForObject(link, String.class);

        return songs;
    }
}