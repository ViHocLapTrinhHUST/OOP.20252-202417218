package hw13b.src;

import java.time.LocalDate;

public class DateModel {
    private LocalDate currentDate;

    public DateModel() {
        currentDate = LocalDate.now();
    }

    public LocalDate getCurrentDate() { return currentDate; }
    public void addDays(int days) { currentDate = currentDate.plusDays(days); }
    public void minusDays(int days) { currentDate = currentDate.minusDays(days); }
    public void addMonths(int months) { currentDate = currentDate.plusMonths(months); }
    public void minusMonths(int months) { currentDate = currentDate.minusMonths(months); }
}