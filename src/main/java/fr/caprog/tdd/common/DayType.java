package fr.caprog.tdd.common;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayType {
    public static boolean isWeekend(LocalDate actualDate) {
        return isSaturday(actualDate) || isSunday(actualDate);
    }

    public static boolean isSunday(LocalDate actualDate) {
        return DayOfWeek.SUNDAY.equals(actualDate.getDayOfWeek());
    }

    public static boolean isSaturday(LocalDate actualDate) {
        return DayOfWeek.SATURDAY.equals(actualDate.getDayOfWeek());
    }
}
