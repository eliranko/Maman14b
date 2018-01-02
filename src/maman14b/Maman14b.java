package maman14b;

import javax.swing.JComboBox;

public class Maman14b {
    public static void main(String[] args) {
        RemindersFileReader fileReader = new RemindersFileReader();
        ReminderFrame frame = new ReminderFrame(getReminderPanel(getDatePanel(), fileReader),
                getReminderMenu(fileReader));
        frame.setVisible(true);
    }
    
    /**
     * Get reminder menu bar
     * @param fileReader File reader
     * @return ReminderMenuBar
     */
    private static ReminderMenuBar getReminderMenu(RemindersFileReader fileReader) {
        return new ReminderMenuBar(fileReader);
    }
    
    /**
     * Get reminder panel
     * @param panel Reminder panel
     * @param fileReader File reader
     * @return ReminderControlPanel
     */
    private static ReminderControlPanel getReminderPanel(DatePanel panel, RemindersFileReader fileReader) {
        return new ReminderControlPanel(panel, fileReader);
    }
    
    /**
     * Get date panel
     * @return DatePanel
     */
    private static DatePanel getDatePanel() {
        // get combo boxes
        JComboBox day = new JComboBox();
        JComboBox month = new JComboBox();
        JComboBox year = new JComboBox();
        
        // get controller
        ComboBoxDateController controller = new ComboBoxDateController(day, month, year);
        controller.setData();
        
        return new DatePanel(day, month, year);
    }
}

