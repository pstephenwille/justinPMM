package com.graham.pomodoro;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.io.IOException;
import java.time.temporal.ChronoUnit;

/**
 * Created by stephen on 1/31/15.
 */
public class CommandBroker {
    /* list of static commands ? */
    
    
    protected static boolean closeApp() {
        Main.primaryStage.close();
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



    public static void createSystemTray(Integer selectedWorkTime, ChronoUnit selectedWorkUnit) throws IOException {
        SystemTray systray = SystemTray.getSystemTray();

        StackPane systrayPane = FXMLLoader.load(Main.LOADER.getResource(("systemTray.fxml")));
        systrayPane.setMinHeight(systray.getTrayIconSize().getHeight());
        systrayPane.setMinWidth(systray.getTrayIconSize().getWidth());
    }

    public static void setMainController(MainController controller) {

    }
}
