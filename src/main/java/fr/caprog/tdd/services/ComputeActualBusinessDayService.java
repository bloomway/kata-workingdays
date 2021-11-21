package fr.caprog.tdd.services;

import fr.caprog.tdd.domain.BusinessDay;

import java.time.LocalDate;

public class ComputeActualBusinessDayService {

    private ComputeActualBusinessDayService() {}

    public static BusinessDay execute(LocalDate givenDate) {
        return BusinessDay.of(givenDate);
    }
}
