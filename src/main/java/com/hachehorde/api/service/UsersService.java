package com.hachehorde.api.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

//import com.hachehorde.api.service.DatabaseService;
//import com.hachehorde.api.controller.HtmlController;
import com.hachehorde.api.model.Users;
import com.hachehorde.api.repository.UsersRepository;

import lombok.Data;

@Data
@Service
public class UsersService {
    
    @Autowired
    private UsersRepository usersRepository;
    
    //private DatabaseService databaseService = new DatabaseService();

    public Optional<Users> getUserById(final Long id) {
        return usersRepository.findById(id);
    }

    public Iterable<Users> getUsers() {
        return usersRepository.findAll();
    }

    public void deleteUser(final Long id) {
        usersRepository.deleteById(id);
    }

    public Users saveUser(Users users) {
        Users savedUser = usersRepository.save(users);
        System.out.println(savedUser.getPassword());
        System.out.println(savedUser.getEmail());
        return savedUser;
    }

    public int logUser(@RequestParam String email, @RequestParam String password, Connection connec, PreparedStatement preparedStatement) {
        try {
            preparedStatement = connec.prepareStatement("SELECT email FROM users WHERE email= '" + email + "' and password= '" + password + "';");
            ResultSet result = preparedStatement.executeQuery();
            if(!result.next()) {
                return 0;
            } else {
                // databaseService.getUserId(email);
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getLocalizedMessage());
        }
        return 1;
    }

}
