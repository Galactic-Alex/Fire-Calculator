package org.galacticalex.firecalculatorjavafx.userInterface.builders;

import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

public class LabelFactory {
    public Label createLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-background-color: lightgrey;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: rgba(38,37,37,0.65);" +
                "-fx-padding: 5;" +
                "-fx-font-weight: bold;"
        );
        label.setPrefSize(113, 35);
        label.setMaxSize(113, 100);
        label.setTextAlignment(TextAlignment.CENTER);
        return label;
    }
}
