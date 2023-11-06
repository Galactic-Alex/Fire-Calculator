import calculator.Calculator;
import userInterface.UserInterface;
import userInterface.UserInterfaceDelegate;
import userInterface.YearInvalidException;

import java.util.Scanner;

public class Main implements UserInterfaceDelegate {
    private final Calculator calculator = new Calculator();

    public static void main(String[] args) throws YearInvalidException {
        Main main = new Main();
        main.userInterfaceSetup();
    }

    @Override
    public double userInterfaceDidScan(Integer userInput) {
        return calculator.calculateWithdrawalPercentage(userInput);
    }

    private void userInterfaceSetup() throws YearInvalidException {
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner);
        userInterface.delegate = this;
        userInterface.startInterface();

    }
}