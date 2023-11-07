package org.galacticalex.firecalculatorjavafx.userInterface.builders;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class HeaderLabelBuilder {
    public Label createHeaderLabel(String text) {
        Label headerLabel = new LabelFactory().createLabel(text);
        headerLabel.setPrefSize(113, 60);
        headerLabel.setMaxSize(113, 60);
        headerLabel.setAlignment(Pos.CENTER);
        return headerLabel;
    }
}
