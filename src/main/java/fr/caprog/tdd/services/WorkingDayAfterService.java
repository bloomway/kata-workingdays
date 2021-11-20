package fr.caprog.tdd.services;

import fr.caprog.tdd.common.DayShift;
import fr.caprog.tdd.common.DayType;
import fr.caprog.tdd.domain.WorkingDay;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WorkingDayAfterService {

    public static WorkingDay compute(LocalDate actualDate) {
        if(isFriday(actualDate) || DayType.isSaturday(actualDate)) {
            return getMonday(actualDate);
        }
        return getTomorrow(actualDate);
    }

    private static WorkingDay getTomorrow(LocalDate actualDate) {
        return WorkingDay.of(incrementDays(actualDate, DayShift.ONE_DAY));
    }

    private static WorkingDay getMonday(LocalDate actualDate) {
        if(DayType.isSaturday(actualDate)) {
            return WorkingDay.of(incrementDays(actualDate, DayShift.TWO_DAYS));
        }
        return WorkingDay.of(incrementDays(actualDate, DayShift.THREE_DAYS));
    }

    private static LocalDate incrementDays(LocalDate actualDate, long daysToAdd) {
        return actualDate.plusDays(daysToAdd);
    }

    private static boolean isFriday(LocalDate actualDate) {
        return DayOfWeek.FRIDAY.equals(actualDate.getDayOfWeek());
    }
}
