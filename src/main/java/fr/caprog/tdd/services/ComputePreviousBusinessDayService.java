package fr.caprog.tdd.services;

import fr.caprog.tdd.common.DayShift;
import fr.caprog.tdd.common.TypeOfDay;
import fr.caprog.tdd.domain.BusinessDay;

import java.time.LocalDate;

public class ComputePreviousBusinessDayService {

    private ComputePreviousBusinessDayService() {}

    public static BusinessDay execute(LocalDate givenDate) {
        if (TypeOfDay.isMonday(givenDate) || TypeOfDay.isSunday(givenDate)) {
            return getFriday(givenDate);
        }
        return getYesterday(givenDate);
    }

    private static BusinessDay getYesterday(LocalDate givenDate) {
        return BusinessDay.of(DayShift.decrementDays(givenDate, DayShift.ONE_DAY));
    }

    private static BusinessDay getFriday(LocalDate givenDate) {
        if (TypeOfDay.isMonday(givenDate)) {
            return BusinessDay.of(DayShift.decrementDays(givenDate, DayShift.THREE_DAYS));
        }
        return BusinessDay.of(DayShift.decrementDays(givenDate, DayShift.TWO_DAYS));
    }
}
