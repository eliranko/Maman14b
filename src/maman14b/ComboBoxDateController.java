package maman14b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ComboBoxDateController implements ActionListener {
    // day const
    private final int DEFAULT_DAY_VALUE = 1;
    // month const
    private final int MIN_MONTH_VALUE = 1;
    private final int MAX_MONTH_VALUE = 12;
    private final int DEFAULT_MONTH_VALUE = 1;
    // year const
    private final int MIN_YEAR_VALUE = 1990;
    private final int MAX_YEAR_VALUE = 2050;
    private final int DEFAULT_YEAR_VALUE = 1993;
    
    private JComboBox<Integer> day;
    private JComboBox<Integer> month;
    private JComboBox<Integer> year;
    private MyDate date;

    public ComboBoxDateController(JComboBox day, JComboBox month, JComboBox year) {
        this();
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public ComboBoxDateController() {
        this.date = new MyDate();
    }

    public JComboBox getDay() {
        return day;
    }

    public final void setDay(JComboBox day) {
        this.day = day;
        this.day.addActionListener(this);
    }

    public JComboBox getMonth() {
        return month;
    }

    public final void setMonth(JComboBox month) {
        this.month = month;
        this.month.addActionListener(this);
    }

    public JComboBox getYear() {
        return year;
    }

    public final void setYear(JComboBox year) {
        this.year = year;
        this.year.addActionListener(this);
    }

    /**
     * Set the combo boxes data
     */
    public void setData() {      
        setAvailableYearsData();
        setChosenYear(DEFAULT_YEAR_VALUE);
        
        setAvailableMonthsData();
        setChosenMonth(DEFAULT_MONTH_VALUE);
        
        setAvailableDaysData();
        setChosenDay(DEFAULT_DAY_VALUE);
    }
    
    private void setAvailableDaysData() {
        // Set available days in the combo box
        Integer[] days = new Integer[this.date.getNumberOfDaysInChosenDate()];
        for(int i = 1; i <= days.length; i++) {
            days[i - 1] = i;
        }
        this.day.setModel(new DefaultComboBoxModel(days));
    }
    
    private void updateAvailableDaysData() {
        int currentDay = this.day == null ? (Integer) this.day.getSelectedItem() : DEFAULT_DAY_VALUE;
        setAvailableDaysData();
        
        // The day is invalid after the changes that were made
        if(currentDay > this.date.getNumberOfDaysInChosenDate()) {
            setChosenDay(DEFAULT_DAY_VALUE);
            JOptionPane.showMessageDialog(null, "The chosen day was invalid after "
                    + "the changed! Set to default value");
        }
        else {
            setChosenDay(currentDay);
        }
    }
    
    private void setChosenDay(int day) {
        this.day.setSelectedItem(day);
        // Set the date object
        this.date.setDay((Integer) this.day.getSelectedItem());
    }
    
    private void setAvailableMonthsData() {
        // Set available month in the combo box
        Integer[] months = new Integer[MAX_MONTH_VALUE - MIN_MONTH_VALUE + 1];
        for(int i = 0; i < months.length; i++) {
            months[i] = i + MIN_MONTH_VALUE;
        }
        this.month.setModel(new DefaultComboBoxModel(months));
    }
    
    private void setChosenMonth(int month) {
        this.month.setSelectedItem(month);
        // Set the date object
        this.date.setMonth((Integer) this.month.getSelectedItem());
        updateAvailableDaysData();
    }
    
    private void setAvailableYearsData() {
        // Set available years in the combo box
        Integer[] years = new Integer[MAX_YEAR_VALUE - MIN_YEAR_VALUE + 1];
        for(int i = 0; i < years.length; i++) {
            years[i] = i + MIN_YEAR_VALUE;
        }
        this.year.setModel(new DefaultComboBoxModel(years));
    }
    
    private void setChosenYear(int year) {
        this.year.setSelectedItem(year);        
        // Set the date object
        this.date.setYear((Integer) this.year.getSelectedItem());
        updateAvailableDaysData();
    }
    
    /**
     * Listen to actions performed by the date combo boxes,
     * changing the chosen day accordingly
     * @param e event object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(!(source instanceof JComboBox)) return;
        
        JComboBox info = (JComboBox) source;
        if(info == day) {
            setChosenDay((Integer) info.getSelectedItem());
        }
        else if(info == month) {
            setChosenMonth((Integer) info.getSelectedItem());
        }
        else {
            setChosenYear((Integer) info.getSelectedItem());
        }
    }
}
