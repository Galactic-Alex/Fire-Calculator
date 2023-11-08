package org.galacticalex.firecalculatorjavafx.userInterface;

import org.galacticalex.firecalculatorjavafx.calculator.Constants;

public class Validator {

    public void validateYear(int year) throws YearInvalidException {
        if (year < Constants.FIRST_YEAR || year > Constants.LAST_YEAR) {
            throw new YearInvalidException("Invalid Starting Year");
        }
    }

}
