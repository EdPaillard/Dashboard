// package com.hachehorde.api.service;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.ResultSet;

// import com.hachehorde.api.controller.HtmlController;

// import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RequestParam;

// @Service
// public class DatabaseService {
    

//     private Connection connec = null;
//     private PreparedStatement preparedStatement = null;
//     private HtmlController htmlController = new HtmlController();

//         public void getUserId(String email) {
//             Long userMail = 0L;
//             try {
//                 Class.forName("com.mysql.jdbc.Driver");
//                 connec = DriverManager.getConnection("jdbc:mysql://localhost/hachehorde?" + "user=dashadmin&password=hachehorde");
//                 preparedStatement = connec.prepareStatement("SELECT id FROM users WHERE email= '" + email + "';");
//                 ResultSet result = preparedStatement.executeQuery();
//                 if(result.next() == true) {
//                 userMail = (result.getLong("id"));
//                 System.out.println(userMail);
//                 htmlController.setIdUser(userMail);
//                 }
                
//             } catch(Exception e) {
//                 e.printStackTrace();
//                 System.err.println(e.getClass().getName()+": "+e.getMessage());
//                 System.exit(0);
//             }             
//         }


// }
