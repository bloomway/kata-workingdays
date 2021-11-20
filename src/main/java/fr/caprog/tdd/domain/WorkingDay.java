package fr.caprog.tdd.domain;

import fr.caprog.tdd.common.DayType;

import java.time.LocalDate;
import java.util.Objects;

public class WorkingDay {

    private LocalDate value;

    protected WorkingDay() {
    }

    private WorkingDay(LocalDate actualDate) {
        this.value = actualDate;
    }

    public static WorkingDay of(LocalDate date) {
        if(DayType.isWeekend(date)) return empty();
        return new WorkingDay(date);
    }

    public static WorkingDay empty() {
        return new WorkingDay();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingDay that = (WorkingDay) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public LocalDate getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "WorkingDay {" + "value=" + value + '}';
    }
}
