package com.hachehorde.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import java.sql.Array;
// import java.sql.ResultSet;
//import java.util.Collections;
//import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

//import com.hachehorde.api.model.Users;
//import com.hachehorde.api.repository.UsersRepository;
//import com.hachehorde.api.service.UsersService;
//import com.hachehorde.api.service.DatabaseService;

//import javax.annotation.security.RolesAllowed;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Controller
public class HtmlController {

    boolean isLogged = false;
    
    private Connection connec = null;
    private PreparedStatement preparedStatement = null;
    // private RegisterController registerController;
    @Autowired
    private UsersController usersController;
    // private Users user;
    // private UsersRepository usersRepository;
    // private Long idUser = 1L;
    // private DatabaseService database;
    
    public HtmlController() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connec = DriverManager.getConnection("jdbc:mysql://localhost/hachehorde?" + "user=dashadmin&password=hachehorde");
            preparedStatement = connec.prepareStatement("CREATE TABLE IF NOT EXISTS users (id LONG, email VARCHAR(50) NOT NULL, password VARCHAR(100) NOT NULL);");
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    // @Bean
    // public Connection connection() {
    //     try {
    //         Class.forName("com.mysql.jdbc.Driver");
    //         connec = DriverManager.getConnection("jdbc:mysql://localhost/hachehorde?" + "user=dashadmin&password=hachehorde");
    //     } catch(Exception e) {
    //         e.printStackTrace();
    //         System.err.println(e.getClass().getName()+": "+e.getMessage());
    //         System.exit(0);
    //     }
    //     return connec;
    // }

    // @PostMapping("/register")
    // public void registerContr(@RequestParam String name, @RequestParam String email, @RequestParam String password, Connection connec, PreparedStatement preparedStatement) {
    //     registerController.register(name, email, password, connec, preparedStatement);
    // }

    // @RolesAllowed({"USER","ADMIN"})
    // @RequestMapping("/admin")
    // public String getAdmin()
    // {
    //    return "Welcome Admin";
    // }
 
    @RequestMapping("/logingit")
    public String getGithub()
    {
      return "home";
    }

    @GetMapping("/")
    public String getIndexHtml() {
        if(!isLogged) {
            return "login";
        }
        return "home";
    }

    // @GetMapping("/user")
    // @ResponseBody
    // public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
    //     isLogged = true;
    //     return Collections.singletonMap("name", principal.getAttribute("name"));
    // }

    @GetMapping("/register")
    public String getRegisterHtml() {
        return "/register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String email, @RequestParam String password, ModelMap model) throws Exception {
        try {
            if(email != "" || password != "" ) {
                System.out.println("BLOP");
                usersController.saveUser(email, password);
                    
                return "login";
            }
            model.put("badRegister", "Mauvais envoi de formulaire.");
            return "register";
        }
        catch(Exception e) {
            return "register";
        }
        
    }

    @GetMapping("/login")
    public String getLoginHtml() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String email, @RequestParam String password) {
        String retour = usersController.login(email, password, connec, preparedStatement);
        if(retour.equals("index")) {
            isLogged = true;
            return "home";
        }
        return "login";        
    }

    @GetMapping("/logout")
    public String getLogoutHtml() {
        isLogged = false;
        return "/login";
    }

    @GetMapping("/profile")
    public String getProfileHtml() {
        if(!isLogged) {
            return "login";
        }
        return "profile";
    }

    @GetMapping("/home")
    public String getHomeHtml() {
        return "home";
    }

    @PostMapping("/saveServices")
    @ResponseBody
    public void saveServices(@RequestBody String service) {
        // String pseudo = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody().getSubject();
        // try {
        //     preparedStatement = connec.prepareStatement("SELECT id FROM hachehorde.users WHERE pseudo= '" + pseudo + "';");
        //     ResultSet result = preparedStatement.executeQuery();
        // } catch(Exception e) {
        //     System.out.println(e.getClass().getName() + ": " + e.getLocalizedMessage());
        // }

        //String str = service.toString();
        System.out.println(service);
    }

    @GetMapping("/getServices")
    @ResponseBody
    public Map<String, String> getServices() {
        Map<String, String> weather = new HashMap<>();
        weather.put("weather", "true");
        weather.put("deezer", "true");
        weather.put("youtube", "true");
        weather.put("news", "true");
        // String[] weather = {"weather" : "true"};
        return weather;
    }

    // @GetMapping("/getWidgets")
    // @ResponseBody
    // public String getWidgets() {
    //     String weathUrl = null;
    //     try {
    //         System.out.println("LE USER ID" + this.idUser);
    //         preparedStatement = connec.prepareStatement("SELECT url FROM weatherwidget WHERE user_id= '" + this.idUser + "';");
    //         ResultSet result = preparedStatement.executeQuery();
    //         if(result.next() == true) {
    //         weathUrl = result.getString("url");
    //         }
    //         return weathUrl;
    //     } catch(Exception e) {
    //         e.printStackTrace();
    //         System.err.println(e.getClass().getName()+": "+e.getMessage());
    //         System.exit(0);
    //     }
    //     return weathUrl;
    // }

    // public void setIdUser(Long userId) {
    //     this.idUser = userId;
    // }

    // public Long getIdUser() {
    //     return idUser;
    // }


}
