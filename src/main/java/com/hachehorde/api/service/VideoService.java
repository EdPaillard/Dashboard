package com.hachehorde.api.service;

// import com.hachehorde.api.controller.HtmlController;
// import com.hachehorde.api.controller.WidgetController;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class VideoService {
    private final String key = "AIzaSyDNpcyII1P4k7-Dz80GNx-UcNrUh7-TmgY";
    // private WidgetController widgetController = new WidgetController();
    // private HtmlController htmlController;

    public String videoByQuery(String query) {
        String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&q="+query+"&maxResults=15&key=" + key;

        // Long userId = htmlController.getIdUser();
        // widgetController.saveYWidget(url, userId);

        RestTemplate restTemplate = new RestTemplate();
        String queryVideo = restTemplate.getForObject(url, String.class);

        return queryVideo;
    }
    public String TopTen(){
        String url = "https://youtube.googleapis.com/youtube/v3/videos?part=snippet&chart=mostPopular&maxResults=10&regionCode=fr&key="+key;

        // Long userId = htmlController.getIdUser();
        // widgetController.saveYWidget(url, userId);

        RestTemplate restTemplate = new RestTemplate();
        String TopTen = restTemplate.getForObject(url, String.class);
        return TopTen;
    }
    public String FetchSubscribersOf(String name){
            String url = "https://www.googleapis.com/youtube/v3/channels?part=statistics&forUsername=" + name + "&fields=items/statistics/subscriberCount&key=" + key;

            // Long userId = htmlController.getIdUser();
            // widgetController.saveYWidget(url, userId);
    
            RestTemplate restTemplate = new RestTemplate();
            String subscribers = restTemplate.getForObject(url, String.class);
    
            return subscribers;
    }
}