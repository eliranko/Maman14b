package maman14b;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

public class ComboBoxDateMonth extends ComboBoxDate {
    private final int MIN_MONTH_VALUE = 1;
    private final int MAX_MONTH_VALUE = 12;
    private final int DEFAULT_MONTH_INDEX = 0;

    public ComboBoxDateMonth(MyDate date, ActionListener listener) {
        super(date, listener);
    }

    public ComboBoxDateMonth(ActionListener listener) {
        super(listener);
    }
    
    @Override
    public void setComboBoxData() {
        Integer[] months = new Integer[MAX_MONTH_VALUE - MIN_MONTH_VALUE + 1];
        for(int i = 0; i < months.length; i++) {
            months[i] = i + MIN_MONTH_VALUE;
        }
        
        setModel(new DefaultComboBoxModel(months));
        setSelectedIndex(DEFAULT_MONTH_INDEX);
    }
}
