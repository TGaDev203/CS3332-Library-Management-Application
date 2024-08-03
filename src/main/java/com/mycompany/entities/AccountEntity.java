/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Account;

/**
 *
 * @author Admin
 */
public class AccountEntity extends BaseEntity {
    public static void insert(Account newAccount) {
        open();

        try {
            String countSql = "SELECT COUNT(*) FROM Account";
            statement = conn.prepareStatement(countSql);
            ResultSet countResultSet = statement.executeQuery();
            countResultSet.next();
            int accountCount = countResultSet.getInt(1);

            String role = (accountCount == 0) ? "Librarian" : "Student";

            String checkSql = "SELECT COUNT(*) FROM Account WHERE emailAddress = ? OR phoneNumber = ?";
            statement = conn.prepareStatement(checkSql);
            statement.setString(1, newAccount.GetEmailAddress());
            statement.setString(2, newAccount.GetPhoneNumber());
            ResultSet checkResultSet = statement.executeQuery();
            checkResultSet.next();
            int existingCount = checkResultSet.getInt(1);

            if (existingCount > 0) {
                Logger.getLogger(AccountEntity.class.getName()).log(Level.SEVERE,
                        "Email or phone number already exists.");
                return;
            }

            String sql = "INSERT INTO Account(accountId, name, emailAddress, phoneNumber, password, role) VALUES (?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);

            statement.setInt(1, newAccount.GetAccountId());
            statement.setString(2, newAccount.GetName());
            statement.setString(3, newAccount.GetEmailAddress());
            statement.setString(4, newAccount.GetPhoneNumber());
            statement.setString(5, newAccount.GetPassword());
            statement.setString(6, role);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccountEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public static void update(Account updateAccount) {
        open();

        try {
            String sql = "UPDATE Account SET name = ?, emailAddress = ?, phoneNumber = ?, password = ? WHERE accountId = ?";
            statement = conn.prepareStatement(sql);

            statement.setString(1, updateAccount.GetName());
            statement.setString(2, updateAccount.GetEmailAddress());
            statement.setString(3, updateAccount.GetEmailAddress().toUpperCase());
            statement.setString(4, updateAccount.GetPhoneNumber());
            statement.setString(5, updateAccount.GetPassword());
            statement.setInt(6, updateAccount.GetAccountId());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccountEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public static void delete(Integer accountId) {
        open();

        String sql = "DELETE FROM Users WHERE AccountId = ?";

        try {
            statement = conn.prepareStatement(sql);

            statement.setInt(1, accountId);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccountEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public static Account GetDataAccountById(Integer accountId) {
        Account account = null;
        open();

        String sql = "SELECT accountId, name, emailAddress, phoneNumber, password, role FROM Account WHERE accountId = ?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, accountId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                account = new Account(
                        resultSet.getInt("accountId"),
                        resultSet.getString("name"),
                        resultSet.getString("emailAddress"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("password"),
                        resultSet.getString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }

        return account;
    }
}