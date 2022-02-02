package com.hachehorde.api.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.hachehorde.api.service.DeezerService;
import com.hachehorde.api.service.NewsService;
import com.hachehorde.api.service.WeatherService;
import com.hachehorde.api.service.VideoService;

@RestController
public class ServiceController {
    WeatherService weather = new WeatherService();
    DeezerService deezer = new DeezerService();
    NewsService news = new NewsService();
    VideoService yt = new  VideoService();

    @RequestMapping(value = "/services/weather/temp", method= RequestMethod.GET)
    public Object temp(@RequestBody @RequestParam("value") String val) {
        System.out.println(weather.Temperature(val));
        return weather.Temperature(val);
    }

    @RequestMapping(value = "/services/music/artist")
    public String artiste(@RequestParam("value") String val) {
        return deezer.Song(val);
    }
    @RequestMapping(value="/services/news/keyword")
    public String keyword(@RequestParam("value")String val){
        return news.NewsPaper(val);
    }
    @RequestMapping(value = "/services/news/topnews")
    public String topnews(@RequestParam("value") String val){
        return news.TopNews(val);
    }
    @RequestMapping(value = "/services/yt/trendingtop")
    public String topTrending(@RequestParam("value")String val){
        return yt.TopTen();
    }
    @RequestMapping(value = "/services/yt/search")
    public String search(@RequestParam("value") String val){
        return yt.videoByQuery(val);
    }
    @RequestMapping(value = "/services/yt/subscribers")
    public String subscribers(@RequestParam("value") String val){
        return yt.FetchSubscribersOf(val);
    }
}