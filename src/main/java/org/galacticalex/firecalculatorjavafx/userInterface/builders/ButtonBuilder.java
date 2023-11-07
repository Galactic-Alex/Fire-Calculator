package org.galacticalex.firecalculatorjavafx.userInterface.builders;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonBuilder {
    public Button createButton(EventHandler<Event> eventHandler) {
        Button button = new Button();
        button.setPrefSize(35, 35);
        button.setMaxSize(35, 35);
        button.setText("Go");
        button.setStyle(
                "-fx-font: 12 arial;" +
                        "-fx-border-color: black;" +
                        "-fx-font-style: italic;" +
                        "-fx-font-weight: bold;"
        );
        button.setOnMouseReleased(eventHandler);
        return button;
    }
}
