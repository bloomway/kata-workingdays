package fr.caprog.tdd.services;

import fr.caprog.tdd.domain.BusinessDay;
import fr.caprog.tdd.domain.BusinessDays;

import java.time.LocalDate;

public class ComputeBusinessDaysService {

    private ComputeBusinessDaysService() {}

    public static BusinessDays execute(LocalDate givenDate) {
        final BusinessDay next = getNextBusinessDay(givenDate);
        final BusinessDay previous = getPreviousBusinessDay(givenDate);
        final BusinessDay current = getCurrentBusinessDay(givenDate);
        return BusinessDays.of(previous, current, next);
    }

    private static BusinessDay getCurrentBusinessDay(LocalDate givenDate) {
        return ComputeActualBusinessDayService.execute(givenDate);
    }

    private static BusinessDay getPreviousBusinessDay(LocalDate givenDate) {
        return ComputePreviousBusinessDayService.execute(givenDate);
    }

    private static BusinessDay getNextBusinessDay(LocalDate givenDate) {
        return ComputeNextBusinessDayService.execute(givenDate);
    }
}
