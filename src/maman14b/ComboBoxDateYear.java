package maman14b;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

public class ComboBoxDateYear extends ComboBoxDate {
    private final int MIN_YEAR_VALUE = 1990;
    private final int MAX_YEAR_VALUE = 2050;
    private final int DEFAULT_YEAR_INDEX = 0;

    public ComboBoxDateYear(MyDate date, ActionListener listener) {
        super(date, listener);
    }

    public ComboBoxDateYear(ActionListener listener) {
        super(listener);
    }
    
    @Override
    public void setComboBoxData() {
        Integer[] years = new Integer[MAX_YEAR_VALUE - MIN_YEAR_VALUE + 1];
        for(int i = 0; i < years.length; i++) {
            years[i] = i + MIN_YEAR_VALUE;
        }
        
        setModel(new DefaultComboBoxModel(years));
        setSelectedIndex(DEFAULT_YEAR_INDEX);
    }
}
