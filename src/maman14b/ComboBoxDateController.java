package maman14b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ComboBoxDateController implements ActionListener {
    // day consts
    private final int DEFAULT_DAY_VALUE = 1;
    // month consts
    private final int MIN_MONTH_VALUE = 1;
    private final int MAX_MONTH_VALUE = 12;
    private final int DEFAULT_MONTH_VALUE = 1;
    // year consts
    private final int MIN_YEAR_VALUE = 1990;
    private final int MAX_YEAR_VALUE = 2050;
    private final int DEFAULT_YEAR_VALUE = 1993;
    
    private JComboBox<Integer> day;
    private JComboBox<Integer> month;
    private JComboBox<Integer> year;
    private MyDate date;

    /**
     * Constructor
     * @param day Day combo box
     * @param month Month combo box
     * @param year Year combo box
     */
    public ComboBoxDateController(JComboBox day, JComboBox month, JComboBox year) {
        this();
        setDay(day);
        setMonth(month);
        setYear(year);
    }
 
    /**
     * Empty constructor
     */
    public ComboBoxDateController() {
        this.date = new MyDate();
    }

    /**
     * Get day combo box
     * @return JComboBox
     */
    public JComboBox getDay() {
        return day;
    }

    /**
     * Set day combo box
     * @param day Combo box of day
     */
    public final void setDay(JComboBox day) {
        this.day = day;
        this.day.addActionListener(this);
    }

    /**
     * Get month combo box
     * @return JComboBox
     */
    public JComboBox getMonth() {
        return month;
    }

    /**
     * Set month combo box
     * @param month Combo box of month
     */
    public final void setMonth(JComboBox month) {
        this.month = month;
        this.month.addActionListener(this);
    }

    /**
     * Get year combo box
     * @return JComboBox
     */
    public JComboBox getYear() {
        return year;
    }

    /**
     * Set year combo box
     * @param year Combo box of year
     */
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
        this.day.setModel(new DefaultComboBoxModel(days)); // set the model in the combo box
    }
    
    private void updateAvailableDaysData() {
        // Get the chosen day
        int chosenDay;
        try {
            chosenDay = this.day != null ? (Integer) this.day.getSelectedItem() : DEFAULT_DAY_VALUE;
        }
        catch(Exception e) { // The day data hasn't been set
            chosenDay = DEFAULT_DAY_VALUE;
        }
        // Update the available days data in the combo box
        setAvailableDaysData();
        
        if(chosenDay > this.date.getNumberOfDaysInChosenDate()) { // The day is invalid after the changes that were made
            setChosenDay(DEFAULT_DAY_VALUE); // Set default day
            JOptionPane.showMessageDialog(null, "The chosen day was invalid after "
                    + "the changed! Set to default value");
        }
        else {
            setChosenDay(chosenDay); // Set the chosen day after the change
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
        this.month.setModel(new DefaultComboBoxModel(months)); // set the model in the combo box
    }
    
    private void setChosenMonth(int month) {
        this.month.setSelectedItem(month);
        // Set the date object
        this.date.setMonth((Integer) this.month.getSelectedItem());
        // Update the day combo box after the change
        updateAvailableDaysData();
    }
    
    private void setAvailableYearsData() {
        // Set available years in the combo box
        Integer[] years = new Integer[MAX_YEAR_VALUE - MIN_YEAR_VALUE + 1];
        for(int i = 0; i < years.length; i++) {
            years[i] = i + MIN_YEAR_VALUE;
        }
        this.year.setModel(new DefaultComboBoxModel(years)); // set the model in the combo box
    }
    
    private void setChosenYear(int year) {
        this.year.setSelectedItem(year);        
        // Set the date object
        this.date.setYear((Integer) this.year.getSelectedItem());
        // Update the day combo box after the change
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
        if(info == this.day) { // A day was changed
            setChosenDay((Integer) info.getSelectedItem());
        }
        else if(info == this.month) { // A month was changed
            setChosenMonth((Integer) info.getSelectedItem());
        }
        else if(info == this.year) { // A year was changed
            setChosenYear((Integer) info.getSelectedItem());
        }
    }
}
