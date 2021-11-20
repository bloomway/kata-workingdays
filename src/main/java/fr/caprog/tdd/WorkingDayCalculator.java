package fr.caprog.tdd;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WorkingDayCalculator {

    private static final int ONE_DAY = 1;
    private static final int TWO_DAYS = 2;
    private static final int THREE_DAYS = 3;

    public static WorkingDay computeWorkingDayBefore(LocalDate actualDate) {
        if (isMonday(actualDate) || isSunday(actualDate)) return getFriday(actualDate);
        return getYesterday(actualDate);
    }

    public static WorkingDay computeWorkingDayAfter(LocalDate actualDate) {
        if(isFriday(actualDate) || isSaturday(actualDate)) return getMonday(actualDate);
        return getTomorrow(actualDate);
    }

    public static WorkingDay computeCurrentWorkingDay(LocalDate actualDate) {
        return WorkingDay.of(actualDate);
    }

    private static WorkingDay getFriday(LocalDate actualDate) {
        if (isMonday(actualDate)) return WorkingDay.of(actualDate.minusDays(THREE_DAYS));
        return WorkingDay.of(actualDate.minusDays(TWO_DAYS));
    }

    private static WorkingDay getMonday(LocalDate actualDate) {
        if(isSaturday(actualDate)) return WorkingDay.of(actualDate.plusDays(TWO_DAYS));
        return WorkingDay.of(actualDate.plusDays(THREE_DAYS));
    }

    private static WorkingDay getYesterday(LocalDate actualDate) {
        return WorkingDay.of(actualDate.minusDays(ONE_DAY));
    }

    private static WorkingDay getTomorrow(LocalDate actualDate) {
        return WorkingDay.of(actualDate.plusDays(ONE_DAY));
    }

    public static boolean isWeekend(LocalDate actualDate) {
        return isSaturday(actualDate) || isSunday(actualDate);
    }

    private static boolean isSunday(LocalDate actualDate) {
        return DayOfWeek.SUNDAY.equals(actualDate.getDayOfWeek());
    }

    private static boolean isMonday(LocalDate actualDate) {
        return DayOfWeek.MONDAY.equals(actualDate.getDayOfWeek());
    }

    private static boolean isSaturday(LocalDate actualDate) {
        return DayOfWeek.SATURDAY.equals(actualDate.getDayOfWeek());
    }

    private static boolean isFriday(LocalDate actualDate) {
        return DayOfWeek.FRIDAY.equals(actualDate.getDayOfWeek());
    }

    public static WorkingDays computeWorkingDays(LocalDate actualDate) {
        return WorkingDays.of(actualDate);
    }

}
