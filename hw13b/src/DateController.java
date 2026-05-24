package hw13b.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DateController {
    private DateModel model;
    private DateView view;

    public DateController(DateModel model, DateView view) {
        this.model = model;
        this.view = view;
        this.view.updateDate(model.getCurrentDate());

        this.view.addActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int x = Integer.parseInt(view.getInputX());
                    if (x < 0) throw new NumberFormatException("Negative number");
                    
                    if (e.getSource() == view.btnMinusDays) model.minusDays(x);
                    else if (e.getSource() == view.btnPlusDays) model.addDays(x);
                    else if (e.getSource() == view.btnMinusMonths) model.minusMonths(x);
                    else if (e.getSource() == view.btnPlusMonths) model.addMonths(x);
                    
                    view.updateDate(model.getCurrentDate());
                } catch (NumberFormatException ex) {
                    view.showError("Please enter a valid positive integer!");
                }
            }
        });
    }
}