package com.graham.pomodoro;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;


public class AppBroker {

    public static final String MAIN_FXML = "main.fxml";
    public static final String SYSTRAY_FXML = "systemTray.fxml";
    public static final String BREAKPERIOD_FXML = "breakperiod.fxml";

    private static Scene sysTrayScene;
    private static Scene uiScene;
    private static Scene breaksScene;


    protected static void loadSysTray() {
        Scene scene = loadScene(null);
        if (scene != null) {
            scene.getAccelerators();
        }
        sysTrayScene = loadScene("systray");
    }

    @Nullable
    protected static Scene loadScene(String cmd) {
        System.out.println("appBroker " + cmd);
        Scene scene = null;
        try {
            return FXMLLoader.load(Main.getResource(cmd));
//            Scene scene = new Scene(parent);
            // Add scene to system tray
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scene;
    }

}k