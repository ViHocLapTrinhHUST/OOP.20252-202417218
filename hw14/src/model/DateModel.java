package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDate;

public class DateModel {
    // Lưu trữ ngày được chọn (base date) và ngày kết quả
    private final ObjectProperty<LocalDate> selectedDate = new SimpleObjectProperty<>(LocalDate.now());
    private final ObjectProperty<LocalDate> resultDate = new SimpleObjectProperty<>();

    public ObjectProperty<LocalDate> selectedDateProperty() { return selectedDate; }
    public ObjectProperty<LocalDate> resultDateProperty() { return resultDate; }

    // Logic tính toán
    public void calculateDate(int amount, String direction, String unit) {
        LocalDate current = selectedDate.get();
        if (current == null) return;
        
        int modifier = direction.equals("Before") ? -amount : amount;
        
        switch (unit) {
            case "Days": resultDate.set(current.plusDays(modifier)); break;
            case "Months": resultDate.set(current.plusMonths(modifier)); break;
            case "Years": resultDate.set(current.plusYears(modifier)); break;
        }
    }
}