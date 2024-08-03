/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import static com.mycompany.entities.BaseEntity.close;
import static com.mycompany.entities.BaseEntity.conn;
import static com.mycompany.entities.BaseEntity.open;
import static com.mycompany.entities.BaseEntity.statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Legion
 */
public class CatalogEntity extends BaseEntity {
    public static List<String> GetBookTitleList() {
        List<String> catalogTitles = new ArrayList<>();
        List<String> uniqueBookTitles = null;
        open();
        try {
            String sql = "Select title From catalog";
            statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                String title = rs.getString("title");
                catalogTitles.add(title);
            }
            Set<String> uniqueTitles = new HashSet<>(catalogTitles);
            uniqueBookTitles = new ArrayList<>(uniqueTitles);
            
        } catch (SQLException ex) {
            Logger.getLogger(CatalogEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return uniqueBookTitles;
    }
}
