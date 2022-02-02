package com.hachehorde.api.service;
// import com.hachehorde.api.controller.HtmlController;
// import com.hachehorde.api.controller.WidgetController;
//import com.hachehorde.api.model.Users;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherService {
    private final String key = "8e0e12c87a2dce2da789a60f5029b5e9";

    // private WidgetController widgetController = new WidgetController();
    // private HtmlController htmlController = new HtmlController();
    //private Users user;

    public String Temperature(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key;

        System.out.println(url);
    
        // Long userId = htmlController.getIdUser();
        // System.out.println(userId);
        // widgetController.saveWWidget(url, userId);

        RestTemplate restTemplate = new RestTemplate();
        String weather = restTemplate.getForObject(url, String.class);

        return weather;
    }
}