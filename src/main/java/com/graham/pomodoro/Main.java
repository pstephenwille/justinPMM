package com.graham.pomodoro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static final String TITLE = "Pomodoro Timer";
    public static final String MAIN_FXML = "main.fxml";
    public static final String SYSTRAY_FXML = "systemTray.fxml";
    public static final String MAIN_CSS = "main.css";
    public static final String ICON = "pomodoro.png";
    public static final ClassLoader LOADER = Main.class.getClassLoader();

    public static void main(String[] args) {
        launch(args);
    }

    public static URL getResource(String fileName) {
        URL url = LOADER.getResource(fileName);
        if (url == null) throw new RuntimeException("Could not find " + fileName);
        return url;
    }

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = createScene(primaryStage);

        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(getIcon());
        primaryStage.setTitle(TITLE);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    protected Scene createScene(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getResource(MAIN_FXML));
        
        Scene scene = new Scene(parent, 500, 300);
        scene.getStylesheets().add(getResource(MAIN_CSS).toExternalForm());
        scene.setOnMousePressed(DraggableWindow.onMousePressed);
        scene.setOnMouseDragged(DraggableWindow.onMouseDragged(primaryStage));

        return scene;
    }

    protected Image getIcon() {
        return new Image(LOADER.getResourceAsStream(ICON));
    }
}
