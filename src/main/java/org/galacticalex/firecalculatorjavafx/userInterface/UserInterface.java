package org.galacticalex.firecalculatorjavafx.userInterface;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;


public class UserInterface {
    public UserInterfaceDelegate delegate;

    private final TextField textField;
    private final BorderPane borderPane;
    private final ArrayList<Label> labelList;
    private final EventHandler<Event> eventHandler;

    public UserInterface() {
        this.textField = createTextField();
        this.borderPane = createBorderPane();
        this.labelList = createLabels();
        this.eventHandler = createEventHandler();

        Button button = createButton();
        HBox hBox = new HBox(textField, button);
        hBox.setAlignment(Pos.CENTER);
        VBox vbox = createVbox(hBox, this.labelList);
        borderPane.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                eventHandler.handle(keyEvent);
            }
        });
        borderPane.setCenter(vbox);
    }

    private TextField createTextField() {
        TextField textField = new TextField();
        textField.setPrefSize(78, 35);
        textField.setMaxSize(78, 35);
        return textField;
    }

    private Label createLabel(String text) {
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

    private BorderPane createBorderPane() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(400, 300);
        borderPane.setMaxSize(400, 300);
        return borderPane;
    }

    private Button createButton() {
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

    private VBox createVbox(HBox hbox, ArrayList<Label> labelList) {
        VBox vbox = new VBox(labelList.get(0), hbox, labelList.get(1), labelList.get(2));
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }

    private ArrayList<Label> createLabels() {
        Label labelInfo = createLabel("Enter a year \n2002-2021 \nto calculate %");
        labelInfo.setPrefSize(113, 60);
        labelInfo.setMaxSize(113, 60);
        labelInfo.setAlignment(Pos.CENTER);
        Label labelYear = createLabel("Year: ");
        Label labelPercent = createLabel("Percentage: ");
        ArrayList<Label> arrayList = new ArrayList<>();
        arrayList.add(labelInfo);
        arrayList.add(labelYear);
        arrayList.add(labelPercent);
        return arrayList;
    }

    private EventHandler<Event> createEventHandler() {
        return event -> {
            String string = textField.getText();
            try {
                int input = Integer.parseInt(string);
                Validator.validateYear(input);
                labelList.get(1).setText("Year: " + textField.getText());
                labelList.get(2).setText("Percentage: " + delegate.userInterfaceDidScan(input));
            } catch (Exception e) {
                labelList.get(1).setText("Bad input!");
                labelList.get(2).setText("No percentage!");
                throw new RuntimeException(e);
            }
        };
    }
    public BorderPane getBorderPane() {
        return borderPane;
    }

}
