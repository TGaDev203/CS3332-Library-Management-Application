/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.libraryhustmanagerment;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List; // Ensure this import
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.entities.BookEntity;
import com.mycompany.entities.CatalogEntity;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Account;
import models.Book;
import models.BorrowBook;

/**
 * FXML Controller class
 *
 * @author Legion
 */
public class FXMLDashBoardConstroller implements Initializable {
    @FXML
    private Button accountBtn;

    @FXML
    private TableColumn<Account, String> account_nameTable;

    @FXML
    private Button account_ResetBtn;

    @FXML
    private Button account_Search;

    @FXML
    private Button account_Update;

    @FXML
    private TextField account_accountID;

    @FXML
    private TableColumn<Account, String> account_accountIDTable;

    @FXML
    private TextField account_age;

    @FXML
    private TableColumn<Account, Integer> account_ageTable;

    @FXML
    private Button account_deleteBtn;

    @FXML
    private TableColumn<Account, String> account_emailTable;

    @FXML
    private TextField account_name;

    @FXML
    private TableColumn<Account, String> account_passwordTableTable;

    @FXML
    private TableColumn<Account, String> account_phoneNumberTable;

    @FXML
    private TextField account_searchByUserID;

    @FXML
    private Button account_selectAccount;

    @FXML
    private Button borrowedBook_returnBook;

    @FXML
    private Button borrowedBook_selectBook;

    @FXML
    private ComboBox<?> borrowedBooks_bookIDSearch;

    @FXML
    private TableColumn<BorrowBook, Integer> borrowedBooks_bookIDTable;

    @FXML
    private TableColumn<BorrowBook, String> borrowedBooks_bookTitleTable;

    @FXML
    private TableColumn<BorrowBook, Date> borrowedBooks_borrowDateTable;

    @FXML
    private ComboBox<Integer> borrowedBooks_borrowIDSearch;

    @FXML
    private TableColumn<BorrowBook, Integer> borrowedBooks_borrowIDTable;

    @FXML
    private Button borrowedBooks_btn;

    @FXML
    private Button borrowedBook_searchBtn;

    @FXML
    private Button borrowedBook_showBorrowedBookBtn;

    @FXML
    private TableColumn<BorrowBook, Date> borrowedBooks_dueDateTable;

    @FXML
    private AnchorPane borrowedBooks_form;

    @FXML
    private TableColumn<BorrowBook, Date> borrowedBooks_returnDateTable;

    @FXML
    private ComboBox<String> borrowedBooks_studentIDSearch;

    @FXML
    private TableColumn<BorrowBook, String> borrowedBooks_studentIDTable;

    @FXML
    private TableView<BorrowBook> borrowedBooks_tableView;

    @FXML
    private Button close_btn;

    @FXML
    private AnchorPane dasboard_form;

    @FXML
    private Label login_role_of_user;

    @FXML
    private Label login_username;

    // @FXML
    // private AnchorPane main_form;

    @FXML
    private Button managerBook_SearchBtn;

    @FXML
    private Button managerBook_addBtn;

    @FXML
    private TextField managerBook_author;

    @FXML
    private TableColumn<Book, String> managerBook_authorTable;

    @FXML
    private ComboBox<String> managerBook_authorsCombobox;

    @FXML
    private TableColumn<Book, Integer> managerBook_availableBookTable;

    @FXML
    private AnchorPane managerBook_bookBorrowUI;

    @FXML
    private Label managerBook_bookBorrowedID;

    @FXML
    private TableColumn<Book, Integer> managerBook_bookID;

    @FXML
    private TextField managerBook_bookTitle;

    @FXML
    private ComboBox<String> managerBook_bookTitleSearch;

    @FXML
    private TableColumn<Book, String> managerBook_bookTitleTable;

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
    private ComboBox<String> managerBook_genreCombobox;

    @FXML
    private TableColumn<?, ?> managerBook_genreTable;

    @FXML
    private TableColumn<?, ?> managerBook_publicationDate;

    @FXML
    private TextField managerBook_publisherField;

    @FXML
    private TableColumn<Book, String> managerBook_publisherTable;

    @FXML
    private Button managerBook_resetBtn;

    @FXML
    private Button managerBook_selectBookBtn;

    @FXML
    private Button managerBook_showAllBookBtn;

    @FXML
    private TextField managerBook_stock;

    @FXML
    private TextField managerBook_studentID;

    @FXML
    private TableView<Book> managerBook_tableView;

    @FXML
    private TableColumn<Book, Integer> managerBook_totalBookTable;

    @FXML
    private Button managerBook_updateBtn;

    @FXML
    private Button minimize_btn;

    @FXML
    private Button signout_btn;

    @FXML
    private TableView<Account> account_TableView;

    @FXML
    private AnchorPane account_form;

    @FXML
    private void dasboard_form_close() {
        System.exit(0);
    }

    @FXML
    private void dasboard_form_minimize() {
        Stage stage = (Stage) dasboard_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void switchForm(ActionEvent event) throws IOException {
        if (event.getSource() == managerBook_btn) {
            managerBook_form.setVisible(true);
            borrowedBooks_form.setVisible(false);
            account_form.setVisible(false);

        } else if (event.getSource() == borrowedBooks_btn) {
            managerBook_form.setVisible(false);
            borrowedBooks_form.setVisible(true);
            account_form.setVisible(false);
        } else if (event.getSource() == accountBtn) {
            managerBook_form.setVisible(false);
            borrowedBooks_form.setVisible(false);
            account_form.setVisible(true);
        }
    }

    @FXML
    private void DisplayUser() {
        login_username.setText("XH");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        SetValueForBookTitlesCatalog();
        SetValueForBookGenreCatalog();
        SetValueForBookAuthorCatalog();
    }

    private Boolean checkStringNotNULL(String nameOfObject, TextField textField) {
        try {
            if (!textField.getText().equals("")) {
                return true;
            } else {
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

    // ! Function AddBook
    @FXML
    private void AddBook() {
        String bookTitle = null;
        // Check string is null or not
        if (checkStringNotNULL("Book Title", managerBook_bookTitle)) {
            bookTitle = managerBook_bookTitle.getText(); // if not will setvalue
        }
        String bookAuthor = null;
        if (checkStringNotNULL("Book Author", managerBook_author)) {
            bookAuthor = managerBook_author.getText();
        }
        Integer stock = null;
        try {
            if (Book.IsValidStock(managerBook_stock.getText())) {
                stock = Integer.valueOf(managerBook_stock.getText());
            } else {
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
        if (checkStringNotNULL("Genre", managerBook_genre)) {
            genre = managerBook_genre.getText();
        }
        String publisher = null;
        if (checkStringNotNULL("Publisher", managerBook_publisherField)) {
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
            SetValueMangagetBookAll();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDashBoardConstroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Set value for comboBox
    private void SetValueForComboBox(ComboBox<String> comboBox, List<String> catalogList, String model) {
        comboBox.getItems().addAll("None");
        for (int i = 0; i < catalogList.size(); i++) {
            comboBox.getItems().addAll(catalogList.get(i));
        }
        comboBox.getSelectionModel().select(model);
    }

    // Set value for BookTitles combobox
    private void SetValueForBookTitlesCatalog() {
        List<String> titleCatalogList = CatalogEntity.GetBookTitleList();
        SetValueForComboBox(managerBook_bookTitleSearch, titleCatalogList, "Book Titles");
    }

    private void SetValueForBookGenreCatalog() {
        List<String> genreCatalogList = CatalogEntity.GetGenreList();
        SetValueForComboBox(managerBook_genreCombobox, genreCatalogList, "Genres");
    }

    private void SetValueForBookAuthorCatalog() {
        List<String> authorCatalogList = CatalogEntity.GetAuhorList();
        SetValueForComboBox(managerBook_authorsCombobox, authorCatalogList, "Authors");
    }

    @FXML
    private void SetValueManagerBookTableViewByCatalog() throws SQLException {
        String titleCatalog = managerBook_bookTitleSearch.getValue();
        String genreCatalog = managerBook_genreCombobox.getValue();
        String authorCatalog = managerBook_authorsCombobox.getValue();
        if ((titleCatalog.equals("Book Titles") || titleCatalog.equals("None")) &&
                (genreCatalog.equals("Genres") || genreCatalog.equals("None")) &&
                (authorCatalog.equals("Authors") || authorCatalog.equals("None"))) {
            SetValueMangagetBookAll();
        } else if ((!titleCatalog.equals("Book Titles") && !titleCatalog.equals("None")) &&
                (genreCatalog.equals("Genres") || genreCatalog.equals("None")) &&
                (authorCatalog.equals("Authors") || authorCatalog.equals("None"))) {
            ObservableList<Book> dataBookByTitle = BookEntity.GetDataBookByTitle(titleCatalog);
            setValueForManagerBookTableView(dataBookByTitle);

        } else if ((!titleCatalog.equals("Book Titles") && !titleCatalog.equals("None")) &&
                (!genreCatalog.equals("Genres") && !genreCatalog.equals("None")) &&
                (authorCatalog.equals("Authors") || authorCatalog.equals("None"))) {
            ObservableList<Book> dataBookByTitleAndGenre = BookEntity.GetDataBookByTitleAndGenre(titleCatalog,
                    genreCatalog);
            setValueForManagerBookTableView(dataBookByTitleAndGenre);

        } else if ((!titleCatalog.equals("Book Titles") && !titleCatalog.equals("None")) &&
                (genreCatalog.equals("Genres") || genreCatalog.equals("None")) &&
                (!authorCatalog.equals("Authors") && !authorCatalog.equals("None"))) {
            ObservableList<Book> dataBookByTitleAndAuthor = BookEntity.GetDataBookByTitleAndAuthor(titleCatalog,
                    authorCatalog);
            setValueForManagerBookTableView(dataBookByTitleAndAuthor);

        } else if ((!titleCatalog.equals("Book Titles") && !titleCatalog.equals("None")) &&
                (!genreCatalog.equals("Genres") && !genreCatalog.equals("None")) &&
                (!authorCatalog.equals("Authors") && !authorCatalog.equals("None"))) {
            ObservableList<Book> dataBookByTitleAndGenreAndAuthor = BookEntity
                    .GetDataBookByTitleAndGenreAndAuthor(titleCatalog, genreCatalog, authorCatalog);
            setValueForManagerBookTableView(dataBookByTitleAndGenreAndAuthor);

        } else if ((titleCatalog.equals("Book Titles") || titleCatalog.equals("None")) &&
                (!genreCatalog.equals("Genres") && !genreCatalog.equals("None")) &&
                (!authorCatalog.equals("Authors") && !authorCatalog.equals("None"))) {
            ObservableList<Book> dataBookByGenreAndAuthor = BookEntity.GetDataBookByGenreAndAuthor(genreCatalog,
                    authorCatalog);
            setValueForManagerBookTableView(dataBookByGenreAndAuthor);

        } else if ((titleCatalog.equals("Book Titles") || titleCatalog.equals("None")) &&
                (!genreCatalog.equals("Genres") && !genreCatalog.equals("None")) &&
                (authorCatalog.equals("Authors") || authorCatalog.equals("None"))) {
            ObservableList<Book> dataBookByGenre = BookEntity.GetDataBookByGenre(genreCatalog);
            setValueForManagerBookTableView(dataBookByGenre);

        } else if ((titleCatalog.equals("Book Titles") || titleCatalog.equals("None")) &&
                (genreCatalog.equals("Genres") || genreCatalog.equals("None")) &&
                (!authorCatalog.equals("Authors") && !authorCatalog.equals("None"))) {
            ObservableList<Book> dataBookByAuthor = BookEntity.GetDataBookByAuthor(authorCatalog);
            setValueForManagerBookTableView(dataBookByAuthor);

        }
    }

    @FXML
    void SetValueMangagetBookAll() throws SQLException {
        ObservableList<Book> bookDataList = BookEntity.GetDataBooks();
        setValueForManagerBookTableView(bookDataList);
    }

    private void setValueForManagerBookTableView(ObservableList<Book> bookDataList) {
        // setvalue for table
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

    /*
     * Initialize selectedBook
     */
    private Book selectedBook = null;

    /*
     * Initialize selectedBook
     */
    @FXML
    private void SelectBook() {
        selectedBook = managerBook_tableView.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!!!");
        alert.setHeaderText("Selected Book successfully!!!");
        alert.setContentText("Book is selected: " + selectedBook.getBookTitle());
        alert.showAndWait();
        SetValueForUpdateForm();
        System.out.print(selectedBook.getBookID());

    }

    private void SetValueForUpdateForm() {
        if (selectedBook != null) {
            managerBook_bookTitle.setText(selectedBook.getBookTitle());
            managerBook_author.setText(selectedBook.getBookAuthor());
            managerBook_stock.setText(selectedBook.getTotalBook().toString());
            managerBook_genre.setText(selectedBook.getGenre());
            managerBook_publisherField.setText(selectedBook.getPublisher());
            Date sqlDate = (Date) selectedBook.getPublicationDate();
            LocalDate localDate = sqlDate.toLocalDate();
            managerBook_date.setValue(localDate);
        }
    }

    // RESET FORM
    @FXML
    private void ResetForm() {
        managerBook_bookTitle.clear();
        managerBook_author.clear();
        managerBook_stock.clear();
        managerBook_genre.clear();
        managerBook_publisherField.clear();
        managerBook_date.setValue(null);
        selectedBook = null;
    }

    // Update FORM
    @FXML
    private void UpdateBook() {
        if (selectedBook != null) {
            try {
                // Lấy giá trị từ các trường nhập liệu
                String title = managerBook_bookTitle.getText();
                String author = managerBook_author.getText();
                Integer totalBook = Integer.valueOf(managerBook_stock.getText());
                String genre = managerBook_genre.getText();
                String publisher = managerBook_publisherField.getText();
                LocalDate pubLocalDate = managerBook_date.getValue();
                Date sqlDate = Date.valueOf(pubLocalDate);

                // Tạo đối tượng Book với dữ liệu mới
                Book updateBook = new Book(title, genre, author, totalBook, publisher, sqlDate);

                // Cập nhật trong cơ sở dữ liệu
                BookEntity.UpdateBook(updateBook, selectedBook);
                System.out.println("Book ID: " + selectedBook.getBookID());

                // Cập nhật bảng dữ liệu
                SetValueMangagetBookAll();

                // Hiển thị thông báo thành công
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success!!!");
                alert.setHeaderText("Update Book successfully!!!");
                alert.setContentText("Book is updated: " + selectedBook.getBookTitle());
                alert.showAndWait();
            } catch (NumberFormatException e) {
                // Xử lý lỗi định dạng số (ví dụ: khi người dùng nhập không phải số vào trường
                // số)
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Input");
                alert.setContentText("Please enter valid numbers for stock.");
                alert.showAndWait();
            } catch (SQLException ex) {
                // Xử lý lỗi cơ sở dữ liệu
                Logger.getLogger(FXMLDashBoardConstroller.class.getName()).log(Level.SEVERE, "Database update error",
                        ex);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Database Error");
                alert.setContentText("Failed to update book in the database.");
                alert.showAndWait();
            }
        } else {
            System.out.println("Selected book is null");
        }
    }

    @FXML
    private void DeleteBook() {
        if (selectedBook != null) {
            int deletedBookID = selectedBook.getBookID();
            BookEntity.DeleteBook(deletedBookID);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!!!");
            alert.setHeaderText("Delete Book successfully!!!");
            alert.setContentText("Book is deleted: " + selectedBook.getBookTitle());
            alert.showAndWait();
            try {
                SetValueMangagetBookAll();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDashBoardConstroller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
