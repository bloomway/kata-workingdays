import fr.caprog.tdd.WorkingDay;
import fr.caprog.tdd.WorkingDayCalculator;
import fr.caprog.tdd.WorkingDays;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class WorkingDaysTest {

    private static final LocalDate PREVIOUS_FRIDAY = LocalDate.of(2021, 11, 12);
    private static final LocalDate CURRENT_MONDAY = LocalDate.of(2021, 11, 15);
    private static final LocalDate CURRENT_TUESDAY = LocalDate.of(2021, 11, 16);
    private static final LocalDate CURRENT_WEDNESDAY = LocalDate.of(2021, 11, 17);
    private static final LocalDate CURRENT_THURSDAY = LocalDate.of(2021, 11, 18);
    private static final LocalDate CURRENT_FRIDAY = LocalDate.of(2021, 11, 19);
    private static final LocalDate CURRENT_SATURDAY = LocalDate.of(2021, 11, 20);
    private static final LocalDate CURRENT_SUNDAY = LocalDate.of(2021, 11, 21);
    private static final LocalDate NEXT_MONDAY = LocalDate.of(2021, 11, 22);

    @Test
    public void it_should_return_the_working_day_before_when_compute_working_day_before_given_date() {
        // When
        final WorkingDay result = WorkingDayCalculator.computeWorkingDayBefore(CURRENT_WEDNESDAY);
        // Then
        assertThat(result).isEqualTo(WorkingDay.of(CURRENT_TUESDAY));
    }

    @Test
    public void it_should_return_friday_when_compute_working_day_before_given_monday() {
        // when
        final WorkingDay result = WorkingDayCalculator.computeWorkingDayBefore(CURRENT_MONDAY);
        // Then
        assertThat(result).isEqualTo(WorkingDay.of(PREVIOUS_FRIDAY));
    }

    @Test
    public void it_should_return_friday_when_compute_working_day_before_given_sunday() {
        // when
        final WorkingDay result = WorkingDayCalculator.computeWorkingDayBefore(CURRENT_SUNDAY);
        // Then
        assertThat(result).isEqualTo(WorkingDay.of(CURRENT_FRIDAY));
    }

    @Test
    public void it_should_return_day_after_when_compute_working_day_after_given_date() {
        // when
        final WorkingDay result = WorkingDayCalculator.computeWorkingDayAfter(CURRENT_WEDNESDAY);
        // Then
        assertThat(result).isEqualTo(WorkingDay.of(CURRENT_THURSDAY));
    }

    @Test
    public void it_should_return_monday_when_compute_working_day_after_given_friday() {

        // when
        final WorkingDay result = WorkingDayCalculator.computeWorkingDayAfter(CURRENT_FRIDAY);
        // then
        assertThat(result).isEqualTo(WorkingDay.of(NEXT_MONDAY));
    }

    @Test
    public void it_should_return_monday_when_compute_working_day_after_given_saturday() {
        // when
        final WorkingDay result = WorkingDayCalculator.computeWorkingDayAfter(CURRENT_SATURDAY);
        // then
        assertThat(result).isEqualTo(WorkingDay.of(NEXT_MONDAY));
    }

    @Test
    public void it_should_return_current_working_day_when_compute_current_working_day_given_date() {
        // when
        final WorkingDay result = WorkingDayCalculator.computeCurrentWorkingDay(CURRENT_MONDAY);
        // then
        assertThat(result).isEqualTo(WorkingDay.of(CURRENT_MONDAY));
    }
    
    @Test
    public void it_should_return_empty_working_day_when_compute_current_working_day_given_weekend() {
        // when
        final WorkingDay result = WorkingDayCalculator.computeCurrentWorkingDay(CURRENT_SATURDAY);
        // Then
        final WorkingDay expectedWorkingDate = WorkingDay.empty();
        assertThat(result).isEqualTo(expectedWorkingDate);
    }

    @Test
    public void it_should_return_wednesday_when_compute_working_day_given_wednesday() {
        // when
        WorkingDay workingDay = WorkingDayCalculator.computeCurrentWorkingDay(CURRENT_WEDNESDAY);
        // then
        WorkingDay expectedWorkingDate = WorkingDay.of(CURRENT_WEDNESDAY);
        assertThat(workingDay).isEqualTo(expectedWorkingDate);
    }

    @Test
    public void it_should_return_friday_and_monday_when_compute_working_days_working_given_saturday() {
        // when
        final WorkingDays saturday = WorkingDayCalculator.computeWorkingDays(CURRENT_SATURDAY);
        // then
        assertThat(saturday.getPrevious()).isEqualTo(WorkingDay.of(CURRENT_FRIDAY));
        assertThat(saturday.getCurrent()).isEqualTo(WorkingDay.empty());
        assertThat(saturday.getNext()).isEqualTo(WorkingDay.of(NEXT_MONDAY));
    }

    @Test
    public void it_should_return_tuesday_wednesday_and_thursday_when_compute_working_days_working_given_wednesday() {
        // when
        final WorkingDays wednesday = WorkingDayCalculator.computeWorkingDays(CURRENT_WEDNESDAY);

        // then
        assertThat(wednesday.getPrevious()).isEqualTo(WorkingDay.of(CURRENT_TUESDAY));
        assertThat(wednesday.getCurrent()).isEqualTo(WorkingDay.of(CURRENT_WEDNESDAY));
        assertThat(wednesday.getNext()).isEqualTo(WorkingDay.of(CURRENT_THURSDAY));
    }

}
