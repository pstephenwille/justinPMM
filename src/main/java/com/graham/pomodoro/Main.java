package com.graham.pomodoro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    public static final String TITLE = "Pomodoro Timer";
    public static final String MAIN_FXML = "main.fxml";
    public static final String MAIN_CSS = "main.css";
    public static final ClassLoader LOADER = Main.class.getClassLoader();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent main = FXMLLoader.load(getResource(MAIN_FXML));
        Scene mainScene = new Scene(main, 500, 250);
        mainScene.getStylesheets().add(getResource(MAIN_CSS).toExternalForm());
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    protected URL getResource(String fileName) {
        URL url = LOADER.getResource(fileName);
        if (url == null) throw new RuntimeException("Could not find " + fileName);
        return url;
    }
}
