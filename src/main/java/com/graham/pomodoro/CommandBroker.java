package com.graham.pomodoro;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.temporal.ChronoUnit;

/**
 * Created by stephen on 1/31/15.
 */
public class CommandBroker {
    public static final String MAIN_FXML = "main.fxml";
    public static final String MAIN_CSS = "main.css";
    
    public static final String TRAY_FXML = "systemTray.fxml";
    
    private static final FXMLLoader fxmlLoader = new FXMLLoader();
    private static final ClassLoader LOADER = CommandBroker.class.getClassLoader();
    
    private static MainController mainController;
    private static SystemTrayController systemTrayController;
    
    protected static boolean closeApp() {
//        Main.primaryStage.close();
        return true;
    }
    
    protected static boolean pauseApp() {
//        Main.primaryStage.pause();
        return true;
    }

    protected static boolean restartApp() {
//        Main.primaryStage.restart();
        return true;
    }

    protected static boolean resetApp() {
//        Main.primaryStage.reset();
        return true;
    }



    public static void createSystemTray() throws IOException {
        SystemTray systemTray = SystemTray.getSystemTray();

        StackPane systemTrayPane = fxmlLoader.load(getResource(TRAY_FXML).openStream());
        systemTrayController = fxmlLoader.getController();
        systemTrayPane.setMinHeight(systemTray.getTrayIconSize().getHeight());
        systemTrayPane.setMinWidth(systemTray.getTrayIconSize().getWidth());
    }
    
    public static Scene getMainScene(Stage primaryStage) throws IOException {
        Parent parent = fxmlLoader.load(getResource(MAIN_FXML).openStream());
        mainController = fxmlLoader.getController();

        Scene scene = new Scene(parent, 500, 300);
        scene.getStylesheets().add(getResource(MAIN_CSS).toExternalForm());
        scene.setOnMousePressed(DraggableWindow.onMousePressed);
        scene.setOnMouseDragged(DraggableWindow.onMouseDragged(primaryStage));

        return scene;
    }

    private static URL getResource(String fileName) {
        URL url = LOADER.getResource(fileName);
        if (url == null) throw new RuntimeException("Could not find " + fileName);
        return url;
    }
}
