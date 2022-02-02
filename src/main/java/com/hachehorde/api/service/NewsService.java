package com.hachehorde.api.service;

// import com.hachehorde.api.controller.HtmlController;
// import com.hachehorde.api.controller.WidgetController;

import org.springframework.web.client.RestTemplate;

public class NewsService {
    private final String key = "f1ff1e11c75c44baad22aa5638d407a3";
    // private WidgetController widgetController = new WidgetController();
    // private HtmlController htmlController = new HtmlController();

    public String NewsPaper(String keyword) {
        String url = "https://newsapi.org/v2/everything?q=" + keyword + "&apiKey=" + key;

        // Long userId = htmlController.getIdUser();
        // widgetController.saveNWidget(url, userId);
        RestTemplate restTemplate = new RestTemplate();
        String newpaper = restTemplate.getForObject(url, String.class);

        return newpaper;
    }

    public String TopNews(String category){
        String url = "https://newsapi.org/v2/top-headlines?country=fr" + "&category=" + category+"&apiKey=" +key;

        // Long userId = htmlController.getIdUser();
        // widgetController.saveNWidget(url, userId);
        RestTemplate restTemplate = new RestTemplate();
        String topnews = restTemplate.getForObject(url, String.class);
        return topnews;
    }
}