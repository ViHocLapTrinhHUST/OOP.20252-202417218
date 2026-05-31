package controller;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.DateModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateController {
    @FXML private DatePicker datePicker;
    @FXML private ComboBox<String> formatComboBox; // Các lựa chọn: dd/MM/yyyy, MM/dd/yyyy, dd.MM.yyyy
    @FXML private Label displayDateLabel;
    
    @FXML private TextField inputNumberField;
    @FXML private ComboBox<String> directionComboBox; // Before, After
    @FXML private ComboBox<String> unitComboBox; // Days, Months, Years
    @FXML private Button applyButton;
    @FXML private Label errorLabel;
    @FXML private Label resultLabel;

    private DateModel model = new DateModel();

    @FXML
    public void initialize() {
        // Khởi tạo giá trị mặc định cho ComboBox
        formatComboBox.getItems().addAll("dd/MM/yyyy", "MM/dd/yyyy", "dd.MM.yyyy");
        formatComboBox.setValue("dd/MM/yyyy");
        
        directionComboBox.getItems().addAll("Before", "After");
        directionComboBox.setValue("After");
        
        unitComboBox.getItems().addAll("Days", "Months", "Years");
        unitComboBox.setValue("Days");

        // Đồng bộ DatePicker với Model
        datePicker.valueProperty().bindBidirectional(model.selectedDateProperty());
        
        displayDateLabel.textProperty().bind(Bindings.createStringBinding(() -> {
            LocalDate date = model.selectedDateProperty().get();
            String format = formatComboBox.getValue();
            if (date != null && format != null) {
                return date.format(DateTimeFormatter.ofPattern(format));
            }
            return "";
        }, model.selectedDateProperty(), formatComboBox.valueProperty()));

        applyButton.disableProperty().bind(
            Bindings.createBooleanBinding(() -> {
                String text = inputNumberField.getText();
                boolean isInvalid = text == null || !text.matches("\\d+");
                errorLabel.setText(isInvalid && text != null && !text.isEmpty() ? "Invalid input!" : "");
                return isInvalid;
            }, inputNumberField.textProperty())
        );

        // Hiển thị kết quả
        model.resultDateProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                resultLabel.setText("Result: " + newVal.format(DateTimeFormatter.ofPattern(formatComboBox.getValue())));
            }
        });
    }

    @FXML
    private void handleApply() {
        try {
            int amount = Integer.parseInt(inputNumberField.getText());
            model.calculateDate(amount, directionComboBox.getValue(), unitComboBox.getValue());
        } catch (NumberFormatException e) {
            errorLabel.setText("Lỗi nhập liệu!"); // Xử lý edge cases [cite: 65]
        }
    }
}