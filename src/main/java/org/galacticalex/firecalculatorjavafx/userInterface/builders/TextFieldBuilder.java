package org.galacticalex.firecalculatorjavafx.userInterface.builders;

import javafx.scene.control.TextField;

public class TextFieldBuilder {
    public TextField createTextField() {
        TextField textField = new TextField();
        textField.setPrefSize(78, 35);
        textField.setMaxSize(78, 35);
        return textField;
    }
}
