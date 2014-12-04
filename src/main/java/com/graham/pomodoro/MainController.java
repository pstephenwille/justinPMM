package com.graham.pomodoro;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import javafx.util.Duration;

import java.net.URL;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public static final EventHandler<KeyEvent> TWO_DIGIT_MAX = event -> {
        if (!event.getCharacter().matches("\\d")) event.consume();
        if (((TextField) event.getSource()).getText().length() >= 2) event.consume();
    };

    // UI Elements
    @FXML private TextField workText;
    @FXML private TextField breakText;
    @FXML private ComboBox<ChronoUnit> workCombo;
    @FXML private ComboBox<ChronoUnit> breakCombo;
    @FXML private Label title;
    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private Label time;
    @FXML private Label error;
    @FXML private Button start;
    @FXML private Button pause;
    @FXML private Button resume;
    @FXML private Button restart;
    @FXML private Button stop;

    private Integer selectedWorkTime;
    private ChronoUnit selectedWorkUnit;
    private Integer selectedBreakTime;
    private ChronoUnit selectedBreakUnit;
    private Timeline timeline;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.title.setText(Main.TITLE);

        ObservableList<ChronoUnit> timeUnitsData = FXCollections.observableArrayList();
        timeUnitsData.addAll(ChronoUnit.SECONDS, ChronoUnit.MINUTES, ChronoUnit.HOURS);

        this.workCombo.setItems(timeUnitsData);
        this.workCombo.getSelectionModel().select(1);

        this.breakCombo.setItems(timeUnitsData);
        this.breakCombo.getSelectionModel().select(1);

        workText.addEventFilter(KeyEvent.KEY_TYPED, TWO_DIGIT_MAX);
        breakText.addEventFilter(KeyEvent.KEY_TYPED, TWO_DIGIT_MAX);
    }

    // ActionEvent Functions

    public void onStart(ActionEvent actionEvent) {
        selectedWorkTime = stringToInt(workText.getText());
        selectedWorkUnit = workCombo.getValue();
        selectedBreakTime = stringToInt(breakText.getText());
        selectedBreakUnit = breakCombo.getValue();
        Boolean validWorkTime = (selectedWorkTime > 0);
        Boolean validBreakTime = (selectedBreakTime > 0);

        if (validBreakTime && validWorkTime) {
            startTimer(selectedWorkTime, selectedWorkUnit);
            hideTimer(false);
        } else {
            error.setText("Times must be greater than 0");
            error.setVisible(true);
        }
    }

    public void onPause(ActionEvent actionEvent) {
        showPause(false);
        timeline.pause();
    }

    public void onResume(ActionEvent actionEvent) {
        showPause(true);
        timeline.play();
    }

    public void onRestart(ActionEvent actionEvent) {
        timeline.stop();
        showPause(true);
        startTimer(selectedWorkTime, selectedWorkUnit);
    }

    public void onStop(ActionEvent actionEvent) {
        timeline.stop();
        resume.setVisible(false);
        hideTimer(true);
    }

    // Utility Functions

    protected void hideTimer(Boolean visible) {
        error.setVisible(visible);
        workText.setVisible(visible);
        workCombo.setVisible(visible);
        breakText.setVisible(visible);
        breakCombo.setVisible(visible);
        label1.setVisible(visible);
        label2.setVisible(visible);
        start.setVisible(visible);

        time.setVisible(!visible);
        pause.setVisible(!visible);
        restart.setVisible(!visible);
        stop.setVisible(!visible);
    }

    protected void showPause(Boolean visible) {
        pause.setVisible(visible);
        resume.setVisible(!visible);
    }

    protected void startTimer(Integer runTime, ChronoUnit unit) {
        Timer myTimer = new Timer(runTime, unit);
        time.setText(myTimer.toString());
        timeline = new Timeline(new KeyFrame(Duration.millis(1000),
                ae -> {
                    time.setText(myTimer.minus(1, ChronoUnit.SECONDS).toString());
                    if (!myTimer.hasTimeLeft()) {
                        timeline.stop();
                        // TODO: Toggle start break buttons
                    }
                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    protected void startBreak() {

    }

    protected Integer stringToInt(String s) {
        return (s == null || "".equals(s)) ? 0 : Integer.parseInt(s);
    }
}
