package com.graham.pomodoro;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

final class DraggableWindow {
    private static double xOffset = 0;
    private static double yOffset = 0;

    public static EventHandler<MouseEvent> onMousePressed = event -> {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    };

    public static EventHandler<MouseEvent> onMouseDragged(final Stage stage) {
        return event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        };
    }

}
