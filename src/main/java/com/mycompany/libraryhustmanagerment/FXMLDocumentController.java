/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package com.mycompany.libraryhustmanagerment;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Legion
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Hyperlink hyperlink;

    @FXML
    private AnchorPane signIn_form;

    @FXML
    private Button signin_close;

    @FXML
    private Hyperlink signin_hyperlink;

    @FXML
    private Button signin_minimize;

    @FXML
    private PasswordField signin_password;

    @FXML
    private TextField signin_username;

    @FXML
    private Button signinbtn;

    @FXML
    private TextField signup_age;

    @FXML
    private Button signup_btn;

    @FXML
    private Button signup_close;

    @FXML
    private TextField signup_email;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private Button signup_miniminze;

    @FXML
    private PasswordField signup_password;

    @FXML
    private TextField signup_phonenumber;

    @FXML
    private TextField signup_username;

    @FXML
    private Label title;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }

    private void switchForm(ActionEvent event) throws IOException {
//        if(event.getSource() == signin_hyperlink){
//            signIn_form.setVisible(false);
//            signup_form.setVisible(true);
//        } else if(event.getSource() == hyperlink) {
//            signIn_form.setVisible(true);
//            signup_form.setVisible(false);
//        }
    }
    @FXML
    private void signIn_close() {
        System.exit(0);
    }
    @FXML
    private void signIn_minimize() {
        Stage stage = (Stage)signIn_form.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    private void signUp_close() {
        System.exit(0);
    }
    @FXML
    private void signUp_minimize() {
        Stage stage = (Stage)signup_form.getScene().getWindow();
        stage.setIconified(true);       
    }
    
    @FXML
     private double x = 0;
     private double y = 0;
    private void switchToDashBoard() throws IOException {
//        App.setRoot("dashboard");
       signinbtn.getScene().getWindow().hide();
       Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
       Stage stage = new Stage();
       Scene scene = new Scene(root);
       root.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
            
            stage.setOpacity(0.8);
        });
        
        root.setOnMouseReleased((MouseEvent event) -> {
            stage.setOpacity(1);
        });

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
