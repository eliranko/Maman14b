package maman14b;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Maman14b {

    public static void main(String[] args) {
        ComboBoxDateListener listener = new ComboBoxDateListener();
        MyDate date = new MyDate();
        ComboBoxDateDay dayComboBox = new ComboBoxDateDay(date, listener);
        dayComboBox.setComboBoxData();
        listener.setDayComboBox(dayComboBox);
        ComboBoxDateMonth monthComboBox = new ComboBoxDateMonth(date, listener);
        monthComboBox.setComboBoxData();
        ComboBoxDateYear yearComboBox = new ComboBoxDateYear(date, listener);
        yearComboBox.setComboBoxData();
        JPanel panel = new DatePanel(dayComboBox, monthComboBox, yearComboBox);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

