package fr.caprog.tdd.services;

import fr.caprog.tdd.domain.WorkingDay;

import java.time.LocalDate;

public class WorkingDayCurrentService {
    public static WorkingDay compute(LocalDate actualDate) {
        return WorkingDay.of(actualDate);
    }
}
