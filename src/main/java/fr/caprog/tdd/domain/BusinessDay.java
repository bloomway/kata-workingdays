package fr.caprog.tdd.domain;

import fr.caprog.tdd.common.TypeOfDay;

import java.time.LocalDate;
import java.util.Objects;

public class BusinessDay {

    private LocalDate value;

    protected BusinessDay() {}

    private BusinessDay(LocalDate actualDate) {
        this.value = actualDate;
    }

    public static BusinessDay of(LocalDate date) {
        if(TypeOfDay.isWeekend(date)) return empty();
        return new BusinessDay(date);
    }

    public static BusinessDay empty() {
        return new BusinessDay();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessDay that = (BusinessDay) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value != null ? value.toString() : "";
    }
}
