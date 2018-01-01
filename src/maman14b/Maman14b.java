package maman14b;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Maman14b {

    public static void main(String[] args) {
        JComboBox day = new JComboBox();
        JComboBox month = new JComboBox();
        JComboBox year = new JComboBox();
        ComboBoxDateController controller = new ComboBoxDateController(day, month, year);
        controller.setData();
        DatePanel datePanel = new DatePanel(day, month, year);
        
        RemindersFileReader fileReader = new RemindersFileReader();
        ReminderControlPanel reminderPanel = new ReminderControlPanel(datePanel, fileReader);
        MenuBar menuBar = new MenuBar(fileReader);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(reminderPanel);
        frame.setJMenuBar(menuBar);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

