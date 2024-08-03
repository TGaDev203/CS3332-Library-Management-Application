/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Legion
 */
public class BaseEntity {
    private static final String DATABASE = "library_hust_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection conn = null;
    public static PreparedStatement statement = null;

    public static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE, USERNAME, PASSWORD);
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connection to database successful!");
                try (Statement stmt = conn.createStatement()) {
                    stmt.executeQuery("SELECT 1");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseEntity.class.getName()).log(Level.SEVERE, "Connection failed!", ex);
        }
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException ex) {
                Logger.getLogger(BaseEntity.class.getName()).log(Level.SEVERE, "Failed to close connection!", ex);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseEntity.class.getName()).log(Level.SEVERE, "Failed to close statement!", ex);
            }
        }
        conn = null;
        statement = null;
    }

    public static void main(String[] args) {
        open();
        close();
    }
}
