package fr.caprog.tdd.common;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TypeOfDay {

    private TypeOfDay() {}

    public static boolean isWeekend(LocalDate givenDate) {
        return isSaturday(givenDate) || isSunday(givenDate);
    }

    public static boolean isSunday(LocalDate givenDate) {
        return DayOfWeek.SUNDAY.equals(givenDate.getDayOfWeek());
    }

    public static boolean isSaturday(LocalDate givenDate) {
        return DayOfWeek.SATURDAY.equals(givenDate.getDayOfWeek());
    }

    public static boolean isMonday(LocalDate givenDate) {
        return DayOfWeek.MONDAY.equals(givenDate.getDayOfWeek());
    }

    public static boolean isFriday(LocalDate givenDate) {
        return DayOfWeek.FRIDAY.equals(givenDate.getDayOfWeek());
    }
}
