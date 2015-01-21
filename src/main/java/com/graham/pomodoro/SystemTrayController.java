package com.graham.pomodoro;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by stephen on 1/21/15.
 */
public class SystemTrayController implements Initializable {
/*
* will have event handlers **/

    @FXML
    StackPane stackPane;
    @FXML
    Scene scene;
    @FXML
    Label digits;
    WritableImage wim;

    String woot = "woot";
    
    public void initialize(URL location, ResourceBundle resourceBundle) {
        System.out.println("sys tray ctlr");

    }
}
