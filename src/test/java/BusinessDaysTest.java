import fr.caprog.tdd.domain.BusinessDay;
import fr.caprog.tdd.domain.BusinessDays;
import fr.caprog.tdd.services.ComputeNextBusinessDayService;
import fr.caprog.tdd.services.ComputePreviousBusinessDayService;
import fr.caprog.tdd.services.ComputeBusinessDaysService;
import fr.caprog.tdd.services.ComputeActualBusinessDayService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class BusinessDaysTest {

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
        final BusinessDay result = ComputePreviousBusinessDayService.execute(CURRENT_WEDNESDAY);
        // Then
        assertThat(result).isEqualTo(BusinessDay.of(CURRENT_TUESDAY));
    }

    @Test
    public void it_should_return_friday_when_compute_working_day_before_given_monday() {
        // when
        final BusinessDay result = ComputePreviousBusinessDayService.execute(CURRENT_MONDAY);
        // Then
        assertThat(result).isEqualTo(BusinessDay.of(PREVIOUS_FRIDAY));
    }

    @Test
    public void it_should_return_friday_when_compute_working_day_before_given_sunday() {
        // when
        final BusinessDay result = ComputePreviousBusinessDayService.execute(CURRENT_SUNDAY);
        // Then
        assertThat(result).isEqualTo(BusinessDay.of(CURRENT_FRIDAY));
    }

    @Test
    public void it_should_return_day_after_when_compute_working_day_after_given_date() {
        // when
        final BusinessDay result = ComputeNextBusinessDayService.execute(CURRENT_WEDNESDAY);
        // Then
        assertThat(result).isEqualTo(BusinessDay.of(CURRENT_THURSDAY));
    }

    @Test
    public void it_should_return_monday_when_compute_working_day_after_given_friday() {

        // when
        final BusinessDay result = ComputeNextBusinessDayService.execute(CURRENT_FRIDAY);
        // then
        assertThat(result).isEqualTo(BusinessDay.of(NEXT_MONDAY));
    }

    @Test
    public void it_should_return_monday_when_compute_working_day_after_given_saturday() {
        // when
        final BusinessDay result = ComputeNextBusinessDayService.execute(CURRENT_SATURDAY);
        // then
        assertThat(result).isEqualTo(BusinessDay.of(NEXT_MONDAY));
    }

    @Test
    public void it_should_return_current_working_day_when_compute_current_working_day_given_date() {
        // when
        final BusinessDay result = ComputeActualBusinessDayService.execute(CURRENT_MONDAY);
        // then
        assertThat(result).isEqualTo(BusinessDay.of(CURRENT_MONDAY));
    }
    
    @Test
    public void it_should_return_empty_working_day_when_compute_current_working_day_given_weekend() {
        // when
        final BusinessDay result = ComputeActualBusinessDayService.execute(CURRENT_SATURDAY);
        // Then
        final BusinessDay expectedWorkingDate = BusinessDay.empty();
        assertThat(result).isEqualTo(expectedWorkingDate);
    }

    @Test
    public void it_should_return_wednesday_when_compute_working_day_given_wednesday() {
        // when
        BusinessDay businessDay = ComputeActualBusinessDayService.execute(CURRENT_WEDNESDAY);
        // then
        BusinessDay expectedWorkingDate = BusinessDay.of(CURRENT_WEDNESDAY);
        assertThat(businessDay).isEqualTo(expectedWorkingDate);
    }

    @Test
    public void it_should_return_friday_and_monday_when_compute_working_days_working_given_saturday() {
        // when
        final BusinessDays saturday = ComputeBusinessDaysService.execute(CURRENT_SATURDAY);
        // then
        assertThat(saturday.getPrevious()).isEqualTo(BusinessDay.of(CURRENT_FRIDAY));
        assertThat(saturday.getCurrent()).isEqualTo(BusinessDay.empty());
        assertThat(saturday.getNext()).isEqualTo(BusinessDay.of(NEXT_MONDAY));
    }

    @Test
    public void it_should_return_tuesday_wednesday_and_thursday_when_compute_working_days_working_given_wednesday() {
        // when
        final BusinessDays wednesday = ComputeBusinessDaysService.execute(CURRENT_WEDNESDAY);

        // then
        assertThat(wednesday.getPrevious()).isEqualTo(BusinessDay.of(CURRENT_TUESDAY));
        assertThat(wednesday.getCurrent()).isEqualTo(BusinessDay.of(CURRENT_WEDNESDAY));
        assertThat(wednesday.getNext()).isEqualTo(BusinessDay.of(CURRENT_THURSDAY));
    }

}
