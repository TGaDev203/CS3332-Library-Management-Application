module com.mycompany.libraryhustmanagerment {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
//    requires fontawesomefx;
    requires de.jensd.fx.glyphs.fontawesome;
    
    opens models to javafx.base;
    opens com.mycompany.libraryhustmanagerment to javafx.fxml;
    exports com.mycompany.libraryhustmanagerment;
}
