/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.libraryhustmanagerment;


import com.mycompany.entities.BookEntity;
import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.sql.Date; // Ensure this import
import java.time.LocalDate;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Book;

/**
 * FXML Controller class
 *
 * @author Legion
 */
public class FXMLDashBoardConstroller implements Initializable {    
    @FXML
    private Button borrowedBook_returnBook;

    @FXML
    private Button borrowedBook_selectBook;

    @FXML
    private ComboBox<?> borrowedBooks_bookIDSearch;

    @FXML
    private TableColumn<?, ?> borrowedBooks_bookIDTable;

    @FXML
    private ComboBox<?> borrowedBooks_bookTitilesSearch;

    @FXML
    private TableColumn<?, ?> borrowedBooks_bookTitleTable;

    @FXML
    private TableColumn<?, ?> borrowedBooks_borrowDateTable;

    @FXML
    private ComboBox<?> borrowedBooks_borrowIDSearch;

    @FXML
    private TableColumn<?, ?> borrowedBooks_borrowIDTable;

    @FXML
    private Button borrowedBooks_btn;

    @FXML
    private TableColumn<?, ?> borrowedBooks_dueDateTable;

    @FXML
    private AnchorPane borrowedBooks_form;

    @FXML
    private TableColumn<?, ?> borrowedBooks_returnDateTable;

    @FXML
    private ComboBox<?> borrowedBooks_studentIDSearch;

    @FXML
    private TableColumn<?, ?> borrowedBooks_studentIDTable;

    @FXML
    private TableView<?> borrowedBooks_tableView;

    @FXML
    private Button close_btn;

    @FXML
    private Button delete_user_btn;

    @FXML
    private Button edit_users_btn;

    @FXML
    private Label login_role_of_user;

    @FXML
    private Label login_username;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button managerBook_addBtn;

    @FXML
    private TextField managerBook_author;

    @FXML
    private TableColumn<?, ?> managerBook_authorTable;

    @FXML
    private TableColumn<?, ?> managerBook_availableBookTable;

    @FXML
    private ComboBox<?> managerBook_bookAuthorSearch;

    @FXML
    private AnchorPane managerBook_bookBorrowUI;

    @FXML
    private Label managerBook_bookBorrowedID;

    @FXML
    private ComboBox<?> managerBook_bookGenres;

    @FXML
    private TableColumn<?, ?> managerBook_bookID;

    @FXML
    private ComboBox<?> managerBook_bookPubDateSearch;

    @FXML
    private TextField managerBook_bookTitle;

    @FXML
    private ComboBox<?> managerBook_bookTitleSearch;

    @FXML
    private TableColumn<?, ?> managerBook_bookTitleTable;

    @FXML
    private Button managerBook_borrowBookBtn;

    @FXML
    private Button managerBook_borrowBookBtnComplete;

    @FXML
    private Button managerBook_btn;

    @FXML
    private DatePicker managerBook_date;

    @FXML
    private Button managerBook_deleteBtn;

    @FXML
    private AnchorPane managerBook_form;

    @FXML
    private TextField managerBook_genre;

    @FXML
    private TableColumn<?, ?> managerBook_genreTable;

    @FXML
    private TableColumn<?, ?> managerBook_publicationDate;

    @FXML
    private TextField managerBook_publisherField;

    @FXML
    private TableColumn<?, ?> managerBook_publisherTable;

    @FXML
    private Button managerBook_resetBtn;

    @FXML
    private Button managerBook_selectBookBtn;

    @FXML
    private TextField managerBook_stock;

    @FXML
    private TextField managerBook_studentID;

    @FXML
    private TableColumn<?, ?> managerBook_totalBookTable;

    @FXML
    private Button managerBook_updateBtn;

    @FXML
    private Button minimize_btn;

    @FXML
    private TableView<Book> managerBook_tableView;

    @FXML
    private Button signout_btn;

    @FXML
    private TableColumn<?, ?> user_usernameTable;

    @FXML
    private Button users_Btn;

    @FXML
    private TableColumn<?, ?> users_PhoneNumTable;

    @FXML
    private TableColumn<?, ?> users_Table;

    @FXML
    private TableView<?> users_TableView;

    @FXML
    private Button users_addRoleBtn;

    @FXML
    private Button users_authorizeBtn;

    @FXML
    private Button users_deleteBtn;

    @FXML
    private TableColumn<?, ?> users_emailTable;

    @FXML
    private AnchorPane users_form;

    @FXML
    private ListView<?> users_roleList;

    @FXML
    private TextField users_roleNameTextField;

    @FXML
    private TextField users_search;

    @FXML
    private Button users_selectUser;
    
    @FXML
    private AnchorPane dasboard_form;
    
    @FXML
    private void dasboard_form_close() {
        System.exit(0);
    }
    @FXML
    private void dasboard_form_minimize() {
        Stage stage = (Stage)dasboard_form.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    private void switchForm(ActionEvent event) throws IOException {
        if(event.getSource() == managerBook_btn){
            managerBook_form.setVisible(true);
            borrowedBooks_form.setVisible(false);
            users_form.setVisible(false);
            
        } else if(event.getSource() == borrowedBooks_btn) {
            managerBook_form.setVisible(false);
            borrowedBooks_form.setVisible(true);
            users_form.setVisible(false);
        } else if(event.getSource() == users_Btn) {
            managerBook_form.setVisible(false);
            borrowedBooks_form.setVisible(false);
            users_form.setVisible(true);
        }
    }
    @FXML
    private void DisplayUser() {
       login_username.setText("XH");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DisplayUser();
        try {
            setValueForManagerBookTableView();
                    } catch (SQLException ex) {
            Logger.getLogger(FXMLDashBoardConstroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Boolean checkStringNotNULL(String nameOfObject, TextField textField) {
        try {
            if (!textField.getText().equals("")) {
                return true;
            } 
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!!!");
                alert.setHeaderText("Add Book Failure!!!");
                alert.setContentText(nameOfObject + " not NULL, please try again!!!");
                alert.showAndWait();
                return false;
            }
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!!");
            alert.setHeaderText("Add Book Failure!!!");
            alert.setContentText(nameOfObject + " not NULL, please try again!!!");
            alert.showAndWait();
            return false;
        }
    }
    //! Function AddBook
    @FXML
    private void AddBook() {
        String bookTitle = null;
        //Check string is null or not
        if(checkStringNotNULL("Book Title", managerBook_bookTitle)) {
            bookTitle = managerBook_bookTitle.getText(); //if not will setvalue
        }
        String bookAuthor = null;
        if(checkStringNotNULL("Book Author", managerBook_author)) {
            bookAuthor = managerBook_author.getText();
        }
        Integer stock = null;
        try {
            if (Book.IsValidStock(managerBook_stock.getText())) {
                stock = Integer.valueOf(managerBook_stock.getText());
            } 
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!!!");
                alert.setHeaderText("Add Book Failure!!!");
                alert.setContentText("Stock must be a positive point number, please try again!!!");
                alert.showAndWait();
                return;
            }
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!!");
            alert.setHeaderText("Add Book Failure!!!");
            alert.setContentText("Stock must be a positive point number, please try again!!!");
            alert.showAndWait();
            return;
        }
        String genre = null;
        if(checkStringNotNULL("Genre", managerBook_genre)) {
            genre = managerBook_genre.getText();
        }
        String publisher = null;
        if(checkStringNotNULL("Publisher", managerBook_publisherField)) {
            publisher = managerBook_publisherField.getText();
        }
        LocalDate selectedDate = managerBook_date.getValue(); 
        Date publicationDate = Date.valueOf(selectedDate);
        
        Book newBook = new Book(bookTitle, genre, bookAuthor, stock, stock, publisher, publicationDate);
        BookEntity.AddBook(newBook);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!!!");
        alert.setHeaderText("Book is added successfully!!!");
        alert.setContentText("Book added is: " + newBook.getBookTitle());
        alert.showAndWait();
        managerBook_bookTitle.clear();
        managerBook_author.clear();
        managerBook_stock.clear();
        managerBook_genre.clear();
        managerBook_publisherField.clear();
        managerBook_date.setValue(null);
        try {
            setValueForManagerBookTableView();
                    } catch (SQLException ex) {
            Logger.getLogger(FXMLDashBoardConstroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void setValueForManagerBookTableView() throws SQLException {
        ObservableList<Book> bookDataList = BookEntity.GetDataBooks();
        managerBook_bookTitleTable.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        managerBook_genreTable.setCellValueFactory(new PropertyValueFactory<>("genre"));
        managerBook_bookID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        managerBook_authorTable.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        managerBook_publisherTable.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        managerBook_publicationDate.setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
        managerBook_totalBookTable.setCellValueFactory(new PropertyValueFactory<>("totalBook"));
        managerBook_availableBookTable.setCellValueFactory(new PropertyValueFactory<>("availBook"));
        managerBook_tableView.setItems(bookDataList);
    }
} 
