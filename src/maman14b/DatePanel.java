package maman14b;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class DatePanel extends JPanel {
    private JComboBox<Integer> day;
    private JComboBox<Integer> month;
    private JComboBox<Integer> year;

    /**
     * Constructor
     * @param day Day combo box
     * @param month Month combo box
     * @param year Year combo box
     */
    public DatePanel(JComboBox<Integer> day, JComboBox<Integer> month, JComboBox<Integer> year) {
        this();
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    /**
     * Empty constructor
     */
    public DatePanel() {
    }

    /**
     * Get day combo box
     * @return JComboBox
     */
    public JComboBox<Integer> getDay() {
        return day;
    }

    /**
     * Set day combo box
     * @param day Combo box of day
     */
    public final void setDay(JComboBox<Integer> day) {
        this.day = day;
        rebuildPanel();
    }

    /**
     * Get month combo box
     * @return JComboBox
     */
    public JComboBox<Integer> getMonth() {
        return month;
    }

    /**
     * Set month combo box
     * @param month Combo box of month
     */
    public final void setMonth(JComboBox<Integer> month) {
        this.month = month;
        rebuildPanel();
    }

    /**
     * Get year combo box
     * @return JComboBox
     */
    public JComboBox<Integer> getYear() {
        return year;
    }

    /**
     * Set year combo box
     * @param year Combo box of year
     */
    public final void setYear(JComboBox<Integer> year) {
        this.year = year;
        rebuildPanel();
    }
    
    /**
     * Get a date object from the chosen dates values
     * @return MyDate object
     */
    public MyDate getDate() {
        return new MyDate((Integer) this.day.getSelectedItem(), 
                (Integer) this.month.getSelectedItem(),
                (Integer) this.year.getSelectedItem());
    }
    
    /**
     * Rebuild the panel, assuming some component has changed.
     * The rebuild operation keeps the good order of: day : month : year
     * in the panel
     */
    private void rebuildPanel() {
        // Don't rebuild if a component is missing
        if(this.day == null || this.month == null || this.year == null) return;
        
        removeAll(); // Clear all of the components
        add(this.day);
        add(this.month);
        add(this.year);
    }
}
