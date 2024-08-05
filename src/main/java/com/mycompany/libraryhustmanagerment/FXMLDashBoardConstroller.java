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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.entities.AccountEntity;
import com.mycompany.entities.BookEntity;
import com.mycompany.entities.CatalogEntity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    private AnchorPane rootPane;

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
    private TableColumn<Account, String> account_accountIDTable;

    @FXML
    private TextField account_accountID;

    @FXML
    private TextField account_name;

    @FXML
    private TextField account_emailAddress;

    @FXML
    private TextField account_phoneNumber;

    @FXML
    private TextField account_password;

    @FXML
    private TableColumn<Account, Integer> account_ageTable;

    @FXML
    private Button account_deleteBtn;

    @FXML
    private TableColumn<Account, String> account_emailTable;

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
    private Label login_role;

    @FXML
    private Label login_accountId;

    @FXML
    private Label login_name;

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
    private TableView<Account> account_accountTableView;

    @FXML
    private TableColumn<Account, Integer> account_accountIdColumn;

    @FXML
    private TableColumn<Account, String> account_nameColumn;

    @FXML
    private TableColumn<Account, String> account_emailAddressColumn;

    @FXML
    private TableColumn<Account, String> account_phoneNumberColumn;

    @FXML
    private TableColumn<Account, String> account_passwordColumn;

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

    // private void getUserNameAndRole() {
    // Account account = new Account();

    // login_accountId.setText(account.GetAccountId().toString());

    // String getUserRole = account.GetRole();

    // if (getUserRole == null) {
    // return;
    // }

    // login_role.setText("Your role: " + getUserRole);
    // }

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

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean showConfirmationAlert(String title, String header, String content) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    private Account account;

    public void DisplayAccountIdRoleAndName(Account account) {
        this.account = account;
        UpdateUI();
    }

    private void UpdateUI() {
        if (account != null) {
            login_accountId.setText(account.GetAccountId().toString());
            login_role.setText(account.GetRole());
            login_name.setText(account.GetName());
            if (account != null && "Student".equals(account.GetRole())) {
                DisableButtonsForStudentRole();
            }
        }
    }

    private void DisableButtonsForStudentRole() {
        DisableButtonWithLockIcon(managerBook_addBtn);
        DisableButtonWithLockIcon(managerBook_updateBtn);
        DisableButtonWithLockIcon(managerBook_resetBtn);
        DisableButtonWithLockIcon(managerBook_deleteBtn);
        DisableButtonWithLockIcon(managerBook_selectBookBtn);
        DisableButtonWithLockIcon(managerBook_borrowBookBtn);
        DisableButtonWithLockIcon(borrowedBook_selectBook);
        DisableButtonWithLockIcon(borrowedBook_returnBook);
        DisableButtonWithLockIcon(accountBtn);
    }

    private void DisableButtonWithLockIcon(Button button) {
        button.setDisable(true);
        button.setOpacity(0.8);
        ImageView lockIcon = new ImageView(
                new Image(getClass().getResourceAsStream("/com/mycompany/libraryhustmanagerment/Images/Lock.png")));
        lockIcon.setFitHeight(16);
        lockIcon.setFitWidth(16);
        button.setGraphic(lockIcon);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        SetValueForBookTitlesCatalog();
        SetValueForBookGenreCatalog();
        SetValueForBookAuthorCatalog();
        account_accountIdColumn.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().GetAccountId()).asObject());
        account_nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().GetName()));
        account_emailAddressColumn
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().GetEmailAddress()));
        account_phoneNumberColumn
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().GetPhoneNumber()));
        account_passwordColumn
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().GetPassword()));
        showAllAccountsInTable();
    }

    private Boolean checkStringNotNULL(String nameOfObject, TextField textField) {
        try {
            if (!textField.getText().equals("")) {
                return true;
            } else {
                showAlert("Error!", "Add Book Failure!", " not NULL, please try again!");
                return false;
            }
        } catch (NumberFormatException ex) {
            showAlert("Error!", "Add Book Failure!", nameOfObject + " not NULL, please try again!");
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
                showAlert("Error!", "Add Book Failure!",
                        "Stock must be a positive point number, please try again!");
                return;
            }
        } catch (NumberFormatException ex) {
            showAlert("Error!", "Add Book Failure!", "Stock must be a positive point number, please try again!");
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
        showAlert("Success!", "Book is added successfully!", "Book added is: " + newBook.getBookTitle());
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
        showAlert("Success!", "Selected Book successfully!", "Book is selected: " + selectedBook.getBookTitle());
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
                String title = managerBook_bookTitle.getText();
                String author = managerBook_author.getText();
                Integer totalBook = Integer.valueOf(managerBook_stock.getText());
                String genre = managerBook_genre.getText();
                String publisher = managerBook_publisherField.getText();
                LocalDate pubLocalDate = managerBook_date.getValue();
                Date sqlDate = Date.valueOf(pubLocalDate);

                Book updateBook = new Book(title, genre, author, totalBook, publisher, sqlDate);

                BookEntity.UpdateBook(updateBook, selectedBook);
                System.out.println("Book ID: " + selectedBook.getBookID());

                SetValueMangagetBookAll();

                showAlert("Success!", "Update Book successfully!",
                        "Book is updated: " + selectedBook.getBookTitle());
            } catch (NumberFormatException e) {
                showAlert("Error", "Invalid Input", "Please enter valid numbers for stock.");
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDashBoardConstroller.class.getName()).log(Level.SEVERE, "Database update error",
                        ex);
                showAlert("Error", "Database Error", "Failed to update book in the database.");
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
            showAlert("Success!", "Delete Book successfully!", "Book is deleted: " + selectedBook.getBookTitle());
            try {
                SetValueMangagetBookAll();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDashBoardConstroller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void signOut() throws IOException {
        boolean signOutConfirmed = showConfirmationAlert("Confirm Sign Out", "Are you sure you want to sign out?",
                "Please confirm if you want to sign out.");

        if (signOutConfirmed) {
            Account account = new Account();
            rootPane.getScene().getWindow().hide();
            account.SetAccountId(null);
            account.SetPassword(null);
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void showAllAccountsInTable() {
        List<Account> accounts = AccountEntity.ShowAllAccounts();
        account_accountTableView.getItems().setAll(accounts);
    }

    @FXML
    private void selectAccount() {
        Account selectedAccount = account_accountTableView.getSelectionModel().getSelectedItem();

        if (selectedAccount != null) {
            account_accountID.setText(selectedAccount.GetAccountId().toString());
            account_name.setText(selectedAccount.GetName());
            account_emailAddress.setText(selectedAccount.GetEmailAddress());
            account_phoneNumber.setText(selectedAccount.GetPhoneNumber());
            account_password.setText(selectedAccount.GetPassword());
        } else {
            showAlert("Selection Error", "No Account Selected", "Please select an account from the list.");
        }
    }

    @FXML
    private void handleUpdateAccount() {
        if (!validateAccountFields()) {
            showAlert("Error", "Invalid Input", "Please ensure all fields are filled in correctly.");
            return;
        }

        Account account = new Account(
                Integer.parseInt(account_accountID.getText()),
                account_name.getText(),
                account_emailAddress.getText(),
                account_phoneNumber.getText(),
                account_password.getText());

        try {
            AccountEntity.UpdateAccount(account);
            showAlert("Success!", "Account Updated", "The account has been successfully updated.");
            refreshAccountTableView();
        } catch (SQLException e) {
            showAlert("Error", "Update Failed", "An error occurred while updating the account.");
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDeleteAccount() {
        int accountId = Integer.parseInt(account_accountID.getText());

        try {
            if (showConfirmationAlert("Delete Account", "Confirm Delete",
                    "Are you sure you want to delete this account?")) {
                AccountEntity.DeleteAccount(accountId);
                showAlert("Success!", "Account Deleted", "The account has been successfully deleted.");
                refreshAccountTableView();
            }
        } catch (SQLException e) {
            showAlert("Error", "Delete Failed", "An error occurred while deleting the account.");
            e.printStackTrace();
        }
    }

    @FXML
    private void refreshAccountTableView() {
        try {
            ObservableList<Account> accounts = AccountEntity.GetAllAccounts();
            account_accountTableView.setItems(accounts);
        } catch (SQLException e) {
            showAlert("Error", "Refresh Failed", "An error occurred while refreshing the account list.");
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSearchByAccountId() {
        String idText = account_searchByUserID.getText();

        if (idText.isEmpty()) {
            showAlert("Error", "Input Required", "Please enter an account ID.");
            return;
        }

        try {
            int accountId = Integer.parseInt(idText);

            Account account = AccountEntity.GetDataAccountById(accountId);

            if (account != null) {
                account_accountID.setText(String.valueOf(account.GetAccountId()));
                account_name.setText(account.GetName());
                account_emailAddress.setText(account.GetEmailAddress());
                account_phoneNumber.setText(account.GetPhoneNumber());
                account_password.setText(account.GetPassword());

                showAlert("Found", "Account Found", "Account " + account.GetAccountId() + " has been found!");
            } else {
                showAlert("Not Found", "Account Not Found", "No account found with the provided ID.");
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid ID", "Please enter a valid numeric account ID.");
            e.printStackTrace();
        }
    }

    private boolean validateAccountFields() {
        return !account_accountID.getText().isEmpty() &&
                !account_name.getText().isEmpty() &&
                !account_emailAddress.getText().isEmpty() &&
                !account_phoneNumber.getText().isEmpty() &&
                !account_password.getText().isEmpty();
    }

    @FXML
    private void clearFields() {
        account_accountID.clear();
        account_name.clear();
        account_emailAddress.clear();
        account_phoneNumber.clear();
        account_password.clear();
    }
}