package org.galacticalex.firecalculatorjavafx.userInterface;

public class Validator {
    static public void validateYear(int year) throws YearInvalidException {
        if (year < 2002 || year > 2021) {
            throw new YearInvalidException("Invalid Starting Year");
        }
    }

}
