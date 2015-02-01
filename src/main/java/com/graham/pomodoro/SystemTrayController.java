package com.graham.pomodoro;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by stephen on 1/12/15.
 */
public class SystemTrayController implements Initializable {

    private static SystemTray sysTray;
    private static TrayIcon trayIcon;
    private static PopupMenu popup;
    private static String command;
    private static ActionListener listener;
    private static BufferedImage buffTrayIcon;

    private static MainController Form = new MainController();
    @FXML
    private StackPane systrayPane;
    @FXML
    private Label systrayDigits;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if ( (!SystemTray.isSupported()) || (sysTray != null) ) {
            return;
        }
        

        buildSystemTray();
        
        
        buildPopupMenus();

        trayIcon = new TrayIcon(buffTrayIcon, "PomodoroMM", popup);
        trayIcon.addActionListener(listener);

        try {
            sysTray.add(trayIcon);
        } catch (AWTException except) {
            CommandBroker.closeApp();
        }
    }/* END if() */

    private void buildSystemTray() {
        sysTray = SystemTray.getSystemTray();

        Double width = sysTray.getTrayIconSize().getWidth();
        Double height = sysTray.getTrayIconSize().getHeight();

        WritableImage image = new WritableImage(width.intValue(), height.intValue());

        Scene trayScene = new Scene(systrayPane, null);
//        systrayDigits.setText(Form.getWorkCombo().toString());

        trayScene.getStylesheets().add(getClass().getClassLoader().getResource("systray.css").toExternalForm());

        buffTrayIcon = new BufferedImage(width.intValue(), height.intValue(), 2);

        SwingFXUtils.fromFXImage(trayScene.snapshot(image), buffTrayIcon);
    }
    
    private void buildPopupMenus() {
        popupMenusEventHandlers();

        MenuItem pause = new MenuItem("Pause");
        pause.addActionListener(listener);

        MenuItem restart = new MenuItem("Restart");
        restart.addActionListener(listener);

        MenuItem reset = new MenuItem("Reset");
        reset.addActionListener(listener);

        MenuItem exit = new MenuItem("Exit");
        exit.addActionListener(listener);

            /* add tray menu options */
        popup = new PopupMenu();
        popup.add(pause);
        popup.addSeparator();
        popup.add(restart);
        popup.addSeparator();
        popup.add(reset);
        popup.addSeparator();
        popup.add(exit);
    }

    protected void popupMenusEventHandlers() {
        listener = e ->
        {
            command = e.getActionCommand().toLowerCase();
            if (command.equals("pause")) {
                System.out.println("pause event");
                Platform.runLater(() -> {
//                        changeColor(pauseColor);
//                        pauseApp();
                });/*fx thread */
            }
            if (command.equals("restart")) {
                System.out.println("restart event");
//                    changeColor(workingColor);
//                    Platform.runLater(() -> restartApp());
            }
            if (command.equals("reset")) {
                System.out.println("tray reset");
                Platform.runLater(() -> {
//                        app.setMinWidth(400);
//                        app.setMinHeight(200);
//                        app.setOpacity(1.0);
//                        app.requestFocus();
                });
            }
            if (command.equals("exit")) {
                sysTray.remove(trayIcon);/* awt thread */

                Platform.runLater(() -> {/* fx thread */
//                        timeoutStages.forEach(s -> s.getStage().close());
//                        changeColor(offColor);

                    CommandBroker.closeApp();
                });
            }
        };

    }

//    protected void
}
