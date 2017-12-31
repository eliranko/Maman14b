package maman14b;

import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public abstract class ComboBoxDate extends JComboBox<Integer> {
    protected MyDate date;

    public ComboBoxDate(MyDate date, ActionListener listener) {
        this(listener);
        this.date = date;
    }

    public ComboBoxDate(ActionListener listener) {
        addActionListener(listener);
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }
    
    /**
     * Initiate the combo box with relevant data
     */
    public abstract void setComboBoxData();
}
