package maman14b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ComboBoxDateListener implements ActionListener {
    private ComboBoxDateDay dayComboBox;

    public ComboBoxDateListener(ComboBoxDateDay dayComboBox) {
        this.dayComboBox = dayComboBox;
    }

    public ComboBoxDateListener() {
    }

    public ComboBoxDateDay getDayComboBox() {
        return dayComboBox;
    }

    public void setDayComboBox(ComboBoxDateDay dayComboBox) {
        this.dayComboBox = dayComboBox;
    }
    
    /**
     * Listen to actions performed by the date combo boxes,
     * changing the chosen day accordingly
     * @param e event object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(!(source instanceof ComboBoxDate)) return;
        
        ComboBoxDate date = (ComboBoxDate) source;
        // Year or month has changed - may affect the number of available days
        if(!(date instanceof ComboBoxDateDay)) {
            // Update the available days in the month
            this.dayComboBox.setComboBoxData();
            
            int chosenDay = this.dayComboBox.getSelectedDay();
            // If failed to set the chosen day
            if(!this.dayComboBox.setSelectedDay(chosenDay)) {
                JOptionPane.showMessageDialog(null, "Chosen day changed from " +
                        chosenDay + " to " + this.dayComboBox.getSelectedDay());
            }
        }
    }
}
