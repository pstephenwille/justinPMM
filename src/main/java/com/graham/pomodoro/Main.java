package com.graham.pomodoro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static final String TITLE = "Pomodoro Timer";
//    public static final String MAIN_FXML = "main.fxml";
//    public static final String MAIN_CSS = "main.css";
    public static final String ICON = "pomodoro.png";
    public static final ClassLoader LOADER = Main.class.getClassLoader();
    
//    protected static Stage primaryStage;

//    public static Parent parent;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        this.primaryStage = primaryStage;

        Scene scene = CommandBroker.getMainScene(primaryStage);
        
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(getIcon());
        primaryStage.setTitle(TITLE);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    

//    protected Scene createFormScene(Stage primaryStage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        parent = fxmlLoader.load(getResource(MAIN_FXML).openStream());
//        MainController controller = (MainController) fxmlLoader.getController();
//        CommandBroker.setMainController(controller);
//        
//        Scene scene = new Scene(parent, 500, 300);
//        scene.getStylesheets().add(getResource(MAIN_CSS).toExternalForm());
//        scene.setOnMousePressed(DraggableWindow.onMousePressed);
//        scene.setOnMouseDragged(DraggableWindow.onMouseDragged(primaryStage));
//        
//        return scene;
//    }

//    protected void createSystemTray() throws IOException {
//        SystemTray systray = SystemTray.getSystemTray();
//
//        StackPane systrayPane = FXMLLoader.load(LOADER.getResource(("systemTray.fxml")));
//        systrayPane.setMinHeight(systray.getTrayIconSize().getHeight());
//        systrayPane.setMinWidth(systray.getTrayIconSize().getWidth());
//    }

//    protected void createBreakScenes() {
//        
//    }
//    protected URL getResource(String fileName) {
//        URL url = LOADER.getResource(fileName);
//        if (url == null) throw new RuntimeException("Could not find " + fileName);
//        return url;
//    }

    protected Image getIcon() {
        return new Image(LOADER.getResourceAsStream(ICON));
    }
}
