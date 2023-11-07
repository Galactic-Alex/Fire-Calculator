package org.galacticalex.firecalculatorjavafx.userInterface.builders;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

public class BorderPaneBuilder {
    public BorderPane createBorderPane(EventHandler<Event> eventHandler) {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(400, 300);
        borderPane.setMaxSize(400, 300);
        borderPane.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                eventHandler.handle(keyEvent);
            }
        });
        return borderPane;
    }
}
