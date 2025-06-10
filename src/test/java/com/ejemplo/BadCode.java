package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Base64;

public class BadCode {

    public static void main(String[] args) throws Exception {
        String userInput = "admin'; DROP TABLE users; --";
        executeQuery(userInput);

        String password = "123456"; // hardcoded password

        String encoded = Base64.getEncoder().encodeToString(password.getBytes()); //  inseguro
        System.out.println("Encoded password: " + encoded);

        for (int i = 0; i < 1000; i++) {  //  código ineficiente
            System.out.println("Log: " + i);
        }

        //  código duplicado
        if (password.equals("123456")) {
            System.out.println("Password is weak!");
        }
        if (password.equals("123456")) {
            System.out.println("Password is weak!");
        }
    }

    //  sin validación, vulnerable a SQL injection
    public static void executeQuery(String input) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM users WHERE username = '" + input + "'";
        stmt.execute(query);
    }

    //  método no utilizado (dead code)
    public static void unused() {
        System.out.println("Nunca se usa");
    }
}
