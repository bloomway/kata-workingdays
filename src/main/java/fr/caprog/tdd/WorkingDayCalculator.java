package fr.caprog.tdd;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

public class WorkingDayCalculator {

    private static final int ONE_DAY = 1;
    private static final int TWO_DAYS = 2;
    private static final int THREE_DAYS = 3;

    public static LocalDate computeWorkingDayBefore(LocalDate actualDate) {
        if (isMonday(actualDate) || isSunday(actualDate)) return getFriday(actualDate);
        return getYesterday(actualDate);
    }

    public static LocalDate computeWorkingDayAfter(LocalDate actualDate) {
        if(isFriday(actualDate) || isSaturday(actualDate)) return getMonday(actualDate);
        return getTomorrow(actualDate);
    }

    public static Optional<LocalDate> computeCurrentWorkingDay(LocalDate actualDate) {
        if (isWeekend(actualDate)) return Optional.empty();
        return Optional.of(actualDate);
    }

    private static LocalDate getFriday(LocalDate actualDate) {
        if (isMonday(actualDate)) return actualDate.minusDays(THREE_DAYS);
        return actualDate.minusDays(TWO_DAYS);
    }

    private static LocalDate getMonday(LocalDate actualDate) {
        if(isSaturday(actualDate)) return actualDate.plusDays(TWO_DAYS);
        return actualDate.plusDays(THREE_DAYS);
    }

    private static LocalDate getYesterday(LocalDate actualDate) {
        return actualDate.minusDays(ONE_DAY);
    }

    private static LocalDate getTomorrow(LocalDate actualDate) {
        return actualDate.plusDays(ONE_DAY);
    }

    private static boolean isWeekend(LocalDate actualDate) {
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

    public static WorkingDay computeWorkingDay(LocalDate actualDate) {
        final LocalDate nextWorkingDay = computeWorkingDayAfter(actualDate);
        final LocalDate previousWorkingDay = computeWorkingDayBefore(actualDate);
        final Optional<LocalDate> currentWorkingDay = computeCurrentWorkingDay(actualDate);
        return WorkingDay.of(previousWorkingDay, currentWorkingDay.orElse(null), nextWorkingDay);
    }
}
