package hw13a.src;

import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {
    private JTextField display;
    private CalculatorLogic logic = new CalculatorLogic();
    private String operator = "";
    private double firstNum = 0;
    private boolean isNewInput = true;

    public CalculatorGUI() {
        setTitle("Mini Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] buttons = {
            "C", "<-", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "="
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(e -> processInput(text));
            btnPanel.add(btn);
        }
        add(btnPanel, BorderLayout.CENTER);
    }

    private void processInput(String text) {
        if ("0123456789.".contains(text)) {
            if (isNewInput) {
                display.setText(text);
                isNewInput = false;
            } else {
                display.setText(display.getText() + text);
            }
        } else if ("+-*/%".contains(text)) {
            try {
                firstNum = Double.parseDouble(display.getText());
                operator = text;
                isNewInput = true;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if ("=".equals(text)) {
            try {
                double secondNum = Double.parseDouble(display.getText());
                double result = logic.calculate(firstNum, secondNum, operator);
                display.setText(String.valueOf(result));
            } catch (Exception ex) {
                display.setText("Error");
            }
            isNewInput = true;
        } else if ("C".equals(text)) {
            display.setText("0");
            firstNum = 0;
            operator = "";
            isNewInput = true;
        } else if ("<-".equals(text)) {
            String current = display.getText();
            if (current.length() > 0 && !isNewInput) {
                display.setText(current.substring(0, current.length() - 1));
                if (display.getText().isEmpty()) display.setText("0");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI().setVisible(true));
    }
}