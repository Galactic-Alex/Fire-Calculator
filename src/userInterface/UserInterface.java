package userInterface;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    public UserInterfaceDelegate delegate;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;

    }

    public void startInterface() throws YearInvalidException {
        while (true) {
            System.out.println("Input:");
            String input = scanner.nextLine();
            int b = Integer.parseInt(input);
            Validator.validateYear(b);
            System.out.println("Output:");
            System.out.println(delegate.userInterfaceDidScan(b));
            System.out.println();
        }
    }
}
