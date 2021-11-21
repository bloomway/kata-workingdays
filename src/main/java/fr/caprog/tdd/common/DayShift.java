package fr.caprog.tdd.common;

import java.time.LocalDate;

public class DayShift {
    public static final long ONE_DAY = 1;
    public static final long TWO_DAYS = 2;
    public static final long THREE_DAYS = 3;

    private DayShift() {}

    public static LocalDate decrementDays(LocalDate givenDate, long daysToSubtract) {
        return givenDate.minusDays(daysToSubtract);
    }

    public static LocalDate incrementDays(LocalDate givenDate, long daysToAdd) {
        return givenDate.plusDays(daysToAdd);
    }
}
