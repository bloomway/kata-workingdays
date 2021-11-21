package fr.caprog.tdd.services;

import fr.caprog.tdd.common.DayShift;
import fr.caprog.tdd.common.TypeOfDay;
import fr.caprog.tdd.domain.BusinessDay;

import java.time.LocalDate;

public class ComputeNextBusinessDayService {

    private ComputeNextBusinessDayService() {}

    public static BusinessDay execute(LocalDate givenDate) {
        if(TypeOfDay.isFriday(givenDate) || TypeOfDay.isSaturday(givenDate)) {
            return getMonday(givenDate);
        }
        return getTomorrow(givenDate);
    }

    private static BusinessDay getTomorrow(LocalDate givenDate) {
        return BusinessDay.of(DayShift.incrementDays(givenDate, DayShift.ONE_DAY));
    }

    private static BusinessDay getMonday(LocalDate givenDate) {
        if(TypeOfDay.isSaturday(givenDate)) {
            return BusinessDay.of(DayShift.incrementDays(givenDate, DayShift.TWO_DAYS));
        }
        return BusinessDay.of(DayShift.incrementDays(givenDate, DayShift.THREE_DAYS));
    }
}
