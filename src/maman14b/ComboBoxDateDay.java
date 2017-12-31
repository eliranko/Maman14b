package maman14b;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

public class ComboBoxDateDay extends ComboBoxDate {
    private final int DAYS_ARRAY_OFFSET = 1;
    private final int DEFAULT_DAY_INDEX = 0;

    public ComboBoxDateDay(MyDate date, ActionListener listener) {
        super(date, listener);
    }

    public ComboBoxDateDay(ActionListener listener) {
        super(listener);
    }
    
    @Override
    public void setComboBoxData() {
        Integer[] days = new Integer[this.date.getNumberOfDaysInChosenDate()];
        for(int i = 0; i < days.length; i++) {
            days[i] = i + DAYS_ARRAY_OFFSET;
        }
        
        setModel(new DefaultComboBoxModel(days));
        setSelectedIndex(DEFAULT_DAY_INDEX);
    }
    
    public int getSelectedDay() {
        return getSelectedIndex() + DAYS_ARRAY_OFFSET;
    }
    
    /**
     * Set a day
     * @param day day to set (starts from 1)
     * @return true if the day is valid, false otherwise
     */
    public boolean setSelectedDay(int day) {
        // Given dates exceeds available day in chosen date
        if(day > this.date.getNumberOfDaysInChosenDate()) {
            setSelectedIndex(DEFAULT_DAY_INDEX);
            return false;
        }
        else {
            setSelectedIndex(day - DAYS_ARRAY_OFFSET);
            return true;
        }
    }
}
