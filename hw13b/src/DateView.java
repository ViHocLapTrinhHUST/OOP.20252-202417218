package hw13b.src;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class DateView extends JFrame {
    private JTextField dateField = new JTextField(15);
    private JTextField inputField = new JTextField(5);
    public JButton btnMinusDays = new JButton("-x Days");
    public JButton btnPlusDays = new JButton("+x Days");
    public JButton btnMinusMonths = new JButton("-x Months");
    public JButton btnPlusMonths = new JButton("+x Months");

    public DateView() {
        setTitle("Date Display MVC");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        dateField.setEditable(false);
        dateField.setFont(new Font("Arial", Font.BOLD, 16));
        
        add(new JLabel("Current Date: "));
        add(dateField);
        add(new JLabel("Enter x: "));
        add(inputField);
        
        JPanel btnPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        btnPanel.add(btnMinusDays);
        btnPanel.add(btnPlusDays);
        btnPanel.add(btnMinusMonths);
        btnPanel.add(btnPlusMonths);
        add(btnPanel);
    }

    public void updateDate(java.time.LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateField.setText(date.format(formatter));
    }

    public String getInputX() { return inputField.getText(); }
    public void showError(String msg) { JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE); }

    public void addActionListeners(ActionListener listener) {
        btnMinusDays.addActionListener(listener);
        btnPlusDays.addActionListener(listener);
        btnMinusMonths.addActionListener(listener);
        btnPlusMonths.addActionListener(listener);
    }
}