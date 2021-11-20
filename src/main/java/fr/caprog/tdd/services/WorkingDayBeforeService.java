package fr.caprog.tdd.services;

import fr.caprog.tdd.common.DayShift;
import fr.caprog.tdd.common.DayType;
import fr.caprog.tdd.domain.WorkingDay;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WorkingDayBeforeService {

    public static WorkingDay compute(LocalDate actualDate) {
        if (isMonday(actualDate) || DayType.isSunday(actualDate)) {
            return getFriday(actualDate);
        }
        return getYesterday(actualDate);
    }

    private static WorkingDay getYesterday(LocalDate actualDate) {
        return WorkingDay.of(decrementDays(actualDate, DayShift.ONE_DAY));
    }

    private static WorkingDay getFriday(LocalDate actualDate) {
        if (isMonday(actualDate)) {
            return WorkingDay.of(decrementDays(actualDate, DayShift.THREE_DAYS));
        }
        return WorkingDay.of(decrementDays(actualDate, DayShift.TWO_DAYS));
    }

    private static LocalDate decrementDays(LocalDate actualDate, long daysToSubtract) {
        return actualDate.minusDays(daysToSubtract);
    }

    private static boolean isMonday(LocalDate actualDate) {
        return DayOfWeek.MONDAY.equals(actualDate.getDayOfWeek());
    }
}
