package org.galacticalex.firecalculatorjavafx.userInterface;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.galacticalex.firecalculatorjavafx.userInterface.builders.*;

import java.util.HashMap;

public class Director {
    private final TextField textField;
    private final HashMap<String, Label> labelMap;
    private final BorderPane borderPane;
    private final Button button;

    public Director(UserInterfaceDelegate userInterfaceDelegate) {
        this.textField = new TextFieldBuilder().createTextField();
        this.labelMap = createLabelHashmap(new LabelFactory());
        EventHandler<Event> eventHandler = new EventHandlerBuilder().createEventHandler(textField, userInterfaceDelegate, labelMap);
        this.button = new ButtonBuilder().createButton(eventHandler);
        this.borderPane = new BorderPaneBuilder().createBorderPane(eventHandler);
    }

    private HashMap<String, Label> createLabelHashmap(LabelFactory labelFactory) {
        Label headerLabel = new HeaderLabelBuilder().createHeaderLabel("Enter a year \n2002-2021 \nto calculate %");
        Label yearLabel = labelFactory.createLabel("Year: ");
        Label percentLabel = labelFactory.createLabel("Percentage: ");
        HashMap<String, Label> labelMap = new HashMap<>();
        labelMap.put("headerLabel", headerLabel);
        labelMap.put("yearLabel", yearLabel);
        labelMap.put("percentLabel", percentLabel);
        return labelMap;
    }

    public TextField getTextField() {
        return textField;
    }

    public HashMap<String, Label> getLabelMap() {
        return labelMap;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public Button getButton() {
        return button;
    }
}
