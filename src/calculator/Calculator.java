package calculator;

public class Calculator {
    private double withdrawalPercent;

    public Calculator() {
    }

    public double calculateWithdrawalPercent(int startingYear) {
        //Binary search
        double start = 0;
        double end = 100.5;
        double highestWithdrawalPercent = 0;
        while (end - start > 0.5) {
            double startingSum = 100;
            double middle = (start + end) / 2;
            middle = middle - (middle % 0.5);
            withdrawalPercent = middle;
            if (calculateFinalSum(startingYear, startingSum) >= 0) {
                highestWithdrawalPercent = middle;
                start = middle;
            } else {
                end = middle;
            }
        }
        return highestWithdrawalPercent;
    }


    private double calculateFinalSum(int year, double currentSum) {
        if (year == Constants.lastYear) {
            return currentSum - withdrawalPercent;
        }
        currentSum = (currentSum - withdrawalPercent) * Constants.findMoexChangeByYear(year);
        year++;
        while (year < Constants.lastYear) {
            currentSum = calculateYearSum(year, currentSum);
            year++;
        }
        return currentSum - inflatePercent(year);
    }

    private double calculateYearSum(int year, double currentSum) {
        return (currentSum - inflatePercent(year)) *
                Constants.findMoexChangeByYear(year);
    }

    private double inflatePercent(int year) {
        withdrawalPercent *= Constants.findInflationByYear(year);
        return withdrawalPercent;
    }
}
