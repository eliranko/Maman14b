package maman14b;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class ReminderFrame extends JFrame {
    private final int frameHeight = 150;
    private final int frameWidth = 700;
    private JPanel reminderPanel;
    private JMenuBar menu;

    /**
     * Constructor
     * @param reminderPanel Reminder panel
     * @param menu Menu bar
     */
    public ReminderFrame(JPanel reminderPanel, JMenuBar menu) {
        this();
        setReminderPanel(reminderPanel);
        setMenu(menu);
    }

    /**
     * Empty constructor
     */
    public ReminderFrame() {
        setSize(700, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Get reminder panel
     * @return JPanel
     */
    public JPanel getReminderPanel() {
        return reminderPanel;
    }

    /**
     * Set reminder panel
     * @param reminderPanel JPanel
     */
    public final void setReminderPanel(JPanel reminderPanel) {
        this.reminderPanel = reminderPanel;
        rebuildFrame();
    }

    /**
     * Get menu bar
     * @return JMenuBar
     */
    public JMenuBar getMenu() {
        return menu;
    }

    /**
     * Set menu bar
     * @param menu JMenuBar
     */
    public final void setMenu(JMenuBar menu) {
        this.menu = menu;
        rebuildFrame();
    }
    
    /**
     * Rebuild the frame, assuming some component has changed
     */
    private void rebuildFrame() {
        // Don't rebuild if a component is missing
        if(this.menu == null || this.reminderPanel == null) return;
        
        removeAll(); // Clear all of the components
        add(this.reminderPanel);
        add(this.menu);
    }
}
