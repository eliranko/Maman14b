package maman14b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar implements ActionListener {
    private final String FILE_MENU_NAME = "File";
    private final String LOAD_FILE_MENU_ITEM_NAME = "Load";
    private final JMenu menuFile;
    private final JMenuItem menuLoad;
    private final JFileChooser fileChooser;
    
    private RemindersFileReader fileReader;

    public MenuBar(RemindersFileReader fileReader) {
        this();
        this.fileReader = fileReader;
    }    
    
    public MenuBar() {
        this.fileChooser = new JFileChooser();
        this.menuFile = new JMenu(FILE_MENU_NAME);
        this.menuLoad = new JMenuItem(LOAD_FILE_MENU_ITEM_NAME);
        this.menuLoad.addActionListener(this);
        
        menuFile.add(menuLoad);
        add(menuFile);
    }

    public RemindersFileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(RemindersFileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == menuLoad) {
            if(this.fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.fileReader.setFile(fileChooser.getSelectedFile());
            }
        }
    }
    
}
