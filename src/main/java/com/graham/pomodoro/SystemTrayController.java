package com.graham.pomodoro;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by stephen on 1/12/15.
 */
public class SystemTrayController implements Initializable {
    
    @FXML private StackPane stackPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(resources);

    }
}
