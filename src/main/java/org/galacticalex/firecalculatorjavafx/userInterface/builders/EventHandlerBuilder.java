package org.galacticalex.firecalculatorjavafx.userInterface.builders;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.galacticalex.firecalculatorjavafx.userInterface.UserInterfaceDelegate;
import org.galacticalex.firecalculatorjavafx.userInterface.Validator;

import java.util.HashMap;

public class EventHandlerBuilder {
    public EventHandler<Event> createEventHandler(TextField textField,
                                                  UserInterfaceDelegate delegate,
                                                  HashMap<String, Label> labelMap) {
        return event -> {
            if (textField.isDisabled()) {
                return;
            }
            String stringInput = textField.getText();
            Validator validator = new Validator();
            try {
                int input = Integer.parseInt(stringInput);
                validator.validateYear(input);
                labelMap.get("yearLabel").setText("Year: " + stringInput);
                labelMap.get("percentLabel").setText("Percentage: " + delegate.userInterfaceDidScan(input));
                textField.setDisable(true);
            } catch (Exception e) {
                Platform.exit();
                throw new RuntimeException(e);
            }
        };
    }
}
