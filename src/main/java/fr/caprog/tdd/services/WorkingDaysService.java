package fr.caprog.tdd.services;

import fr.caprog.tdd.domain.WorkingDay;
import fr.caprog.tdd.domain.WorkingDays;

import java.time.LocalDate;

public class WorkingDaysService {

    public static WorkingDays compute(LocalDate actualDate) {
        final WorkingDay nextWorkingDay = WorkingDayAfterService.compute(actualDate);
        final WorkingDay previousWorkingDay = WorkingDayBeforeService.compute(actualDate);
        final WorkingDay currentWorkingDay = WorkingDayCurrentService.compute(actualDate);
        return WorkingDays.of(previousWorkingDay, currentWorkingDay, nextWorkingDay);
    }

}
