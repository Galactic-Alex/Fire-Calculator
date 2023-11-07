package userInterface;

import calculator.Constants;

public class Validator {
    private final Constants constants = new Constants();

    public void validateYear(int year) throws YearInvalidException {
        if (year < constants.getFirstYear() || year > constants.getLastYear()) {
            throw new YearInvalidException("Invalid Starting Year");
        }
    }

}
