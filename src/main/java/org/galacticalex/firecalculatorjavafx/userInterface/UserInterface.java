package org.galacticalex.firecalculatorjavafx.userInterface;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;


public class UserInterface {
    private final UserInterfaceDelegate delegate;

    public UserInterface(UserInterfaceDelegate delegate) {
        this.delegate = delegate;
    }

    public BorderPane createInterface() {
        Director director = new Director(delegate);
        HashMap<String, Label> labelMap = director.getLabelMap();
        BorderPane borderPane = director.getBorderPane();
        HBox hBox = new HBox(director.getTextField(), director.getButton());
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(labelMap.get("headerLabel"), hBox, labelMap.get("yearLabel"), labelMap.get("percentLabel"));
        vBox.setAlignment(Pos.CENTER);
        borderPane.setCenter(vBox);
        return borderPane;
    }

}
