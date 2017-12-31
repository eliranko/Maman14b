package maman14b;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class DatePanel extends JPanel {
    private JComboBox<Integer> day;
    private JComboBox<Integer> month;
    private JComboBox<Integer> year;

    public DatePanel(JComboBox<Integer> day, JComboBox<Integer> month, JComboBox<Integer> year) {
        this();
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public DatePanel() {
        
    }

    public JComboBox<Integer> getDay() {
        return day;
    }

    public final void setDay(JComboBox<Integer> day) {
        this.day = day;
        rebuildPanel();
    }

    public JComboBox<Integer> getMonth() {
        return month;
    }

    public final void setMonth(JComboBox<Integer> month) {
        this.month = month;
        rebuildPanel();
    }

    public JComboBox<Integer> getYear() {
        return year;
    }

    public final void setYear(JComboBox<Integer> year) {
        this.year = year;
        rebuildPanel();
    }
    
    /**
     * Rebuild the panel, assuming some component has changed
     */
    private void rebuildPanel() {
        // Don't rebuild if a component is missing
        if(this.day == null || this.month == null || this.year == null) return;
        
        removeAll();
        add(this.day);
        add(this.month);
        add(this.year);
    }
}
