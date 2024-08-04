package com.mycompany.libraryhustmanagerment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
//    private double x = 0;
//    private double y = 0;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = loadFXML("FXMLDocument"); // Default: 640, 480
        scene = new Scene(root);

//        root.setOnMousePressed((MouseEvent event) -> {
//            x = event.getSceneX();
//            y = event.getSceneY();
//        });
//
//        root.setOnMouseDragged((MouseEvent event) -> {
//            stage.setX(event.getScreenX() - x);
//            stage.setY(event.getScreenY() - y);
//            
//            stage.setOpacity(0.8);
//        });
//        
//        root.setOnMouseReleased((MouseEvent event) -> {
//            stage.setOpacity(1);
//        });

        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
