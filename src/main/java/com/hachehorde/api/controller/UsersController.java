package com.hachehorde.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hachehorde.api.model.Users;
import com.hachehorde.api.service.UsersService;

@Controller
public class UsersController { 
    
    @Autowired
    private UsersService usersService;
    
    @GetMapping("/users")
    @ResponseBody
    public Iterable<Users> getUsers() {
        return usersService.getUsers();
    }

    public Users saveUser(@RequestParam String email, @RequestParam String password) {
        System.out.println("BLOUP");
        Users n = new Users();
        n.setEmail(email);
        n.setPassword(password);
        System.out.println(n.getPassword());
        System.out.println(n.getEmail());
        System.out.println("BLOUP");
        return usersService.saveUser(n);
    }

    public String login(@RequestParam String email, @RequestParam String password, Connection connec, PreparedStatement preparedStatement) {
        int logging;
        if(email != null && password != null) {
            String mail = email;
            String pwd = password;

            if(mail != null && pwd != null) {
                logging = usersService.logUser(email, password, connec, preparedStatement);
                // String jws = Jwts.builder().setSubject(pseudo).signWith(key).compact();
                // assert Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws).getBody().getSubject().equals(pseudo);
                // System.out.println(jws);
                // System.out.println(key);
                if(logging ==1) {
                    return "index";
                }
            } 
        }
        return "login";      
    }
}
