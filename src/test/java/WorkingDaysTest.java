import fr.caprog.tdd.WorkingDay;
import fr.caprog.tdd.WorkingDayCalculator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

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
        final LocalDate result = WorkingDayCalculator.computeWorkingDayBefore(CURRENT_WEDNESDAY);
        // Then
        assertThat(result).isEqualTo(CURRENT_TUESDAY);
    }

    @Test
    public void it_should_return_friday_when_compute_working_day_before_given_monday() {
        // when
        final LocalDate result = WorkingDayCalculator.computeWorkingDayBefore(CURRENT_MONDAY);
        // Then
        assertThat(result).isEqualTo(PREVIOUS_FRIDAY);
    }

    @Test
    public void it_should_return_friday_when_compute_working_day_before_given_sunday() {
        // when
        final LocalDate result = WorkingDayCalculator.computeWorkingDayBefore(CURRENT_SUNDAY);
        // Then
        assertThat(result).isEqualTo(CURRENT_FRIDAY);
    }

    @Test
    public void it_should_return_day_after_when_compute_working_day_after_given_date() {
        // when
        final LocalDate result = WorkingDayCalculator.computeWorkingDayAfter(CURRENT_WEDNESDAY);
        // Then
        assertThat(result).isEqualTo(CURRENT_THURSDAY);
    }

    @Test
    public void it_should_return_monday_when_compute_working_day_after_given_friday() {

        // when
        final LocalDate result = WorkingDayCalculator.computeWorkingDayAfter(CURRENT_FRIDAY);
        // then
        assertThat(result).isEqualTo(NEXT_MONDAY);
    }

    @Test
    public void it_should_return_monday_when_compute_working_day_after_given_saturday() {
        // when
        final LocalDate result = WorkingDayCalculator.computeWorkingDayAfter(CURRENT_SATURDAY);
        // then
        assertThat(result).isEqualTo(NEXT_MONDAY);
    }

    @Test
    public void it_should_return_current_working_day_when_compute_current_working_day_given_date() {
        // when
        final Optional<LocalDate> result = WorkingDayCalculator.computeCurrentWorkingDay(CURRENT_MONDAY);
        // then
        assertThat(result).isEqualTo(Optional.of(CURRENT_MONDAY));
    }
    
    @Test
    public void it_should_return_empty_working_day_when_compute_current_working_day_given_weekend() {
        // when
        final Optional<LocalDate> result = WorkingDayCalculator.computeCurrentWorkingDay(CURRENT_SATURDAY);
        // Then
        assertThat(result).isEqualTo(Optional.empty());
    }

    @Test
    public void it_should_return_current_working_day_when_compute_working_day_given_wednesday() {
        // when
        WorkingDay workingDay = WorkingDayCalculator.computeWorkingDay(CURRENT_WEDNESDAY);
        // then
        WorkingDay expectedWorkingDate = WorkingDay.of(CURRENT_TUESDAY, CURRENT_WEDNESDAY, CURRENT_THURSDAY);
        assertThat(workingDay).isEqualTo(expectedWorkingDate);
    }


}
