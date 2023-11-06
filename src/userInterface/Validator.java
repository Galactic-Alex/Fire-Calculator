package userInterface;

import calculator.Constants;

public class Validator {
    static public void validateYear(int year) throws YearInvalidException {
        if (year < Constants.firstYear || year > Constants.lastYear) {
            throw new YearInvalidException("Invalid Starting Year");
        }
    }

}
