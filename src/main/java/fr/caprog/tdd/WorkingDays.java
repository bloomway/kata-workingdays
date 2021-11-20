package fr.caprog.tdd;

import java.time.LocalDate;

public class WorkingDays {
    private WorkingDay previous;
    private WorkingDay current;
    private WorkingDay next;

    protected WorkingDays() {}

    private WorkingDays(WorkingDay previous, WorkingDay current, WorkingDay next) {
        this.previous = previous;
        this.current = current;
        this.next = next;
    }

    static WorkingDays of(LocalDate actualDate) {
        final WorkingDay nextWorkingDay = WorkingDayCalculator.computeWorkingDayAfter(actualDate);
        final WorkingDay previousWorkingDay = WorkingDayCalculator.computeWorkingDayBefore(actualDate);
        final WorkingDay currentWorkingDay = WorkingDayCalculator.computeCurrentWorkingDay(actualDate);
        return new WorkingDays(previousWorkingDay, currentWorkingDay, nextWorkingDay);
    }

    public WorkingDay getPrevious() {
        return previous;
    }

    public WorkingDay getCurrent() {
        return current;
    }

    public WorkingDay getNext() {
        return next;
    }
}
