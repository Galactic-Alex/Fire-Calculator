package org.galacticalex.firecalculatorjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.galacticalex.firecalculatorjavafx.calculator.Calculator;
import org.galacticalex.firecalculatorjavafx.userInterface.UserInterface;
import org.galacticalex.firecalculatorjavafx.userInterface.UserInterfaceDelegate;

public class FireCalculatorApplication extends Application implements UserInterfaceDelegate {

    private final Calculator calculator = new Calculator();


    @Override
    public void start(Stage stage) {
        UserInterface userInterface = new UserInterface();
        userInterface.delegate = this;

        Scene scene = new Scene(userInterface.getBorderPane());
        stage.setTitle("Fire Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public double userInterfaceDidScan(Integer userInput) {
        return calculator.calculateWithdrawalPercentage(userInput);
    }
}