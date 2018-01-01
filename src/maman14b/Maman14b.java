package maman14b;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Maman14b {

    public static void main(String[] args) {
        JComboBox day = new JComboBox();
        JComboBox month = new JComboBox();
        JComboBox year = new JComboBox();
        ComboBoxDateController controller = new ComboBoxDateController(day, month, year);
        controller.setData();
        JPanel panel = new DatePanel(day, month, year);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

