package org.galacticalex.firecalculatorjavafx.calculator;

public class Calculator {
    private double percentageToWithdraw;
    private final Constants constants = new Constants();

    public Calculator() {
    }

    public double calculateWithdrawalPercentage(int startingYear) {
        double start = 0;
        double end = 100.5;
        double percentage = 0;
        while (end - start > 0.5) {
            double currentSum = 100;
            double middle = (start + end) / 2;
            middle = middle - (middle % 0.5);
            percentageToWithdraw = middle;
            if (calculateFinalSum(startingYear, currentSum) >= 0) {
                percentage = middle;
                start = middle;
            } else {
                end = middle;
            }
        }
        return percentage;
    }


    private double calculateFinalSum(int year, double currentSum) {
        if (year == 2021) {
            return currentSum - percentageToWithdraw;
        }
        currentSum = (currentSum - percentageToWithdraw)
                * (constants.findMoexByYear(year + 1) / constants.findMoexByYear(year));
        year++;
        while (year < 2021) {
            currentSum = calculateOneYearSum(year, currentSum);
            year++;
        }
        return currentSum - incrementPercentage(year);
    }

    private double calculateOneYearSum(int year, double currentSum) {
        return (currentSum - incrementPercentage(year)) *
                (constants.findMoexByYear(year + 1) / constants.findMoexByYear(year));
    }

    private double incrementPercentage(int year) {
        percentageToWithdraw = percentageToWithdraw * (constants.findInflationByYear(year) / 100 + 1);
        return percentageToWithdraw;
    }
}
