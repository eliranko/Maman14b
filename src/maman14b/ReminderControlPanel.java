package maman14b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReminderControlPanel extends JPanel implements ActionListener {
    private final String SAVE_REMINDER_BUTTON_TEXT = "Save reminder";
    private final String FETCH_REMINDER_BUTTON_TEXT = "Fetch reminder";
    private final String EMPTY_REMINDER = "-EMPTY-";
    private final int REMINDER_TEXT_FIELD_COLUMNS = 20;
    
    private DatePanel datePanel;
    private JTextField reminderTextField;
    private JButton saveReminderButton;
    private JButton fetchReminerButton;
    private RemindersFileReader fileReader;

    /**
     * Constructor
     * @param datePanel Date panel
     * @param fileReader File reader
     */
    public ReminderControlPanel(DatePanel datePanel, RemindersFileReader fileReader) {
        this(datePanel);
        this.fileReader = fileReader;
    }
    
    /**
     * Constructor
     * @param datePanel Date panel
     */
    public ReminderControlPanel(DatePanel datePanel) {
        this();
        this.datePanel = datePanel;
        rebuildPanel();
    }

    /**
     * Empty constructor
     */
    public ReminderControlPanel() {
        this.reminderTextField = new JTextField("", REMINDER_TEXT_FIELD_COLUMNS);
        this.reminderTextField.addActionListener(this);
        
        this.saveReminderButton = new JButton(SAVE_REMINDER_BUTTON_TEXT);
        this.saveReminderButton.addActionListener(this);
        
        this.fetchReminerButton = new JButton(FETCH_REMINDER_BUTTON_TEXT);
        this.fetchReminerButton.addActionListener(this);
        
        rebuildPanel();
    }

    /**
     * Get date panel
     * @return Date panel
     */
    public DatePanel getDatePanel() {
        return datePanel;
    }

    /**
     * Set date panel
     * @param datePanel DatePanel
     */
    public void setDatePanel(DatePanel datePanel) {
        this.datePanel = datePanel;
        rebuildPanel();
    }

    /**
     * Get file reader
     * @return RemindersFileReader
     */
    public RemindersFileReader getFileReader() {
        return fileReader;
    }

    /**
     * Set file reader
     * @param fileReader RemindersFileReader
     */
    public void setFileReader(RemindersFileReader fileReader) {
        this.fileReader = fileReader;
    }
    
    /**
     * Rebuild the panel, assuming some component has changed.
     * The rebuild operation keeps the good order of: date : text : buttons
     * in the panel
     */
    private void rebuildPanel() {
        // Don't rebuild if a component is missing
        if(this.reminderTextField == null || 
                this.saveReminderButton == null || 
                this.datePanel == null ||
                this.fetchReminerButton == null) return;
        
        removeAll();
        add(this.datePanel);
        add(this.reminderTextField);
        add(this.saveReminderButton);
        add(this.fetchReminerButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        // User asked to save a reminder
        if(source == this.saveReminderButton) {
            handleSaveClicked();
        }
        // User asked to fetch the reminder
        else if(source == this.fetchReminerButton) {
            handleFetchClicked();
        }
    }
    
    private void handleSaveClicked() {
        this.fileReader.addReminder(this.datePanel.getDate(), this.reminderTextField.getText());
        this.reminderTextField.setText("");
    }
    
    private void handleFetchClicked() {
        String input = JOptionPane.showInputDialog("The reminder is: " +
                getCurrentDateReminder() + 
                "\nWould you like to change it?");

        // The user canceled
        if(input == null) return;

        this.fileReader.addReminder(this.datePanel.getDate(), input);
    }
    
    private String getCurrentDateReminder() {
        String reminder = this.fileReader.getReminder(this.datePanel.getDate());
        return reminder != null && !reminder.equals("") ? reminder : EMPTY_REMINDER;
    }
}
