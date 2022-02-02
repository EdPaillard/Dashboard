package com.hachehorde.api.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;

// import com.hachehorde.api.widget.DeezerWidget;
// import com.hachehorde.api.widget.NewsWidget;
// import com.hachehorde.api.widget.WeatherWidget;
// import com.hachehorde.api.widget.VideoWidget;
// import com.hachehorde.api.model.Deezer;
// import com.hachehorde.api.model.Weather;
// import com.hachehorde.api.model.News;
// import com.hachehorde.api.model.Youtube;

// @Controller
// public class WidgetController {

//     private Connection connec = null;
//     private PreparedStatement preparedStatement = null;
    
//     private DeezerWidget deezerWidget = new DeezerWidget();
//     private NewsWidget newsWidget = new NewsWidget();
//     private VideoWidget videoWidget = new VideoWidget();
//     private WeatherWidget weatherWidget = new WeatherWidget();
    
    // @GetMapping("/deezerwidgets")
    // public Iterable<Deezer> getDWidget() {
    //     return deezerWidget.getWidgets();
    // }

    // public void saveDWidget(String url, Long userId) {
    //     try {
    //         Class.forName("com.mysql.jdbc.Driver");
    //         connec = DriverManager.getConnection("jdbc:mysql://localhost/hachehorde?" + "user=dashadmin&password=hachehorde");
    //         preparedStatement = connec.prepareStatement("INSERT INTO deezerwidget(name, url, user_id) VALUES ('Deezer', '" + url + "', '" + userId + "');");
    //         preparedStatement.executeUpdate();
    //     } catch(Exception e) {
    //         e.printStackTrace();
    //         System.err.println(e.getClass().getName()+": "+e.getMessage());
    //         System.exit(0);
    //     }
        
    //     Deezer n = new Deezer();
    //     n.setName("Deezer");
    //     n.setUrl(url);
    //     return deezerWidget.saveWidget(n);
    // }

    // @GetMapping("/newswidgets")
    // public Iterable<News> getNWidget() {
    //     return newsWidget.getWidgets();
    // }

    // public void saveNWidget(String url, Long userId) {
    //     try {
    //         Class.forName("com.mysql.jdbc.Driver");
    //         connec = DriverManager.getConnection("jdbc:mysql://localhost/hachehorde?" + "user=dashadmin&password=hachehorde");
    //         preparedStatement = connec.prepareStatement("INSERT INTO newswidget(name, url, user_id) VALUES ('News', '" + url + "', '" + userId + "');");
    //         preparedStatement.executeUpdate();
    //     } catch(Exception e) {
    //         e.printStackTrace();
    //         System.err.println(e.getClass().getName()+": "+e.getMessage());
    //         System.exit(0);
    //     }
    //     News n = new News();
    //     n.setName("News");
    //     n.setUrl(url);
    //     return newsWidget.saveWidget(n);
    // }

    // @GetMapping("/youtubewidgets")
    // public Iterable<Youtube> getYWidget() {
    //     return videoWidget.getWidgets();
    // }

    // public void saveYWidget(String url, Long userId) {
    //     try {
    //         Class.forName("com.mysql.jdbc.Driver");
    //         connec = DriverManager.getConnection("jdbc:mysql://localhost/hachehorde?" + "user=dashadmin&password=hachehorde");
    //         preparedStatement = connec.prepareStatement("INSERT INTO youtubewidget(name, url, user_id) VALUES ('Youtube', '" + url + "', '" + userId + "');");
    //         preparedStatement.executeUpdate();
    //     } catch(Exception e) {
    //         e.printStackTrace();
    //         System.err.println(e.getClass().getName()+": "+e.getMessage());
    //         System.exit(0);
    //     }
    //     Youtube n = new Youtube();
    //     n.setName("Youtube");
    //     n.setUrl(url);
    //     return videoWidget.saveWidget(n);
    // }

    // @GetMapping("/weatherwidgets")
    // public Iterable<Weather> getWWidget() {
    //     return weatherWidget.getWidgets();
    // }

    // public void saveWWidget(String url, Long userId) {
    //     try {
    //         Class.forName("com.mysql.jdbc.Driver");
    //         connec = DriverManager.getConnection("jdbc:mysql://localhost/hachehorde?" + "user=dashadmin&password=hachehorde");
    //         preparedStatement = connec.prepareStatement("INSERT INTO weatherwidget(id, name, url, user_id) VALUES ('0', 'Weather', '" + url + "', '" + userId + "');");
    //         preparedStatement.executeUpdate();
    //     } catch(Exception e) {
    //         e.printStackTrace();
    //         System.err.println(e.getClass().getName()+": "+e.getMessage());
    //         System.exit(0);
    //     }


        // System.out.println("T'es où bug ?");
        // Weather n = new Weather();
        // n.setName("Weather");
        // n.setUrl(url);
        // System.out.println(n);
        // return weatherWidget.saveWidget(n);
//     }

// }
