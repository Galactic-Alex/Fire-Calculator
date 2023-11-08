package calculator;

public class Constants {
    //The year MOEX and INFLATION statistics start from
    public static final int FIRST_YEAR = 2002;
    //Last withdrawal in 2021
    public static final int LAST_YEAR = 2021;

    //Индекс мос биржи с 2002 по 2022 сверху вниз
    public static final double[] MOEX_RATE = {
            417.42,
            673.72,
            722.81,
            1323.32,
            2216.63,
            2472.38,
            810.922,
            1793.24,
            2209.46,
            1835.14,
            1934.43,
            1967.83,
            1828.06,
            2305.50,
            3042.00,
            3015.71,
            3564.05,
            4887.25,
            5567.28,
            6731.43,
            4170.35
    };
    //Инфляция с 2002 по 2022 сверху вниз
    public static final double[] INFLATION_RATE = {
            15.06,
            11.99,
            11.74,
            10.91,
            9.00,
            11.87,
            13.28,
            8.80,
            8.78,
            6.10,
            6.58,
            6.45,
            11.36,
            12.91,
            5.38,
            2.52,
            4.27,
            03.05,
            4.91,
            8.39,
            11.92,
    };

    public Constants() {
    }

    public double findMoexChangeByYear(Integer year) {
        return MOEX_RATE[findIndexByYear(year) + 1] / MOEX_RATE[findIndexByYear(year)];
    }

    public double findInflationByYear(Integer year) {
        return INFLATION_RATE[findIndexByYear(year)] / 100 + 1;
    }

    private int findIndexByYear(Integer year) {
        //Array indices aren't directly equal to year values
        //So, we subtract the first year from the given year,
        //to calculate the index of the needed value
        return year - Constants.FIRST_YEAR;
    }
}
