package userInterface;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    public UserInterfaceDelegate delegate;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startInterface() throws YearInvalidException {
        System.out.println("Input:");
        int inputYear = scanner.nextInt();
        Validator.validateYear(inputYear);
        System.out.println("Output:");
        System.out.println(delegate.userInterfaceDidScan(inputYear));
    }
}
