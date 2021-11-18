package fr.caprog.tdd;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class WorkingDay {

    private LocalDate previous;
    private LocalDate current;
    private LocalDate next;

    protected WorkingDay() {
    }

    private WorkingDay(LocalDate previousWorkingDay, LocalDate actualDate, LocalDate nextWorkingDay) {
        this.previous = previousWorkingDay;
        this.current = actualDate;
        this.next = nextWorkingDay;
    }

    public static WorkingDay of(
            LocalDate previousWorkingDay,
            LocalDate actualDate,
            LocalDate nextWorkingDay
    ) {
        return new WorkingDay(previousWorkingDay, actualDate, nextWorkingDay);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingDay that = (WorkingDay) o;
        return previous.equals(that.previous) &&
                Objects.equals(current, that.current) &&
                next.equals(that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(previous, current, next);
    }

    public LocalDate getPrevious() {
        return previous;
    }

    public Optional<LocalDate> getCurrent() {
        return current != null ? Optional.of(current) : Optional.empty();
    }

    public LocalDate getNext() {
        return next;
    }

}
