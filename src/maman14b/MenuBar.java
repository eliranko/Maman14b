package maman14b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBar extends JMenuBar implements ActionListener {
    private final String FILE_MENU_NAME = "File";
    private final String LOAD_FILE_MENU_ITEM_NAME = "Load";
    private final String SAVE_FILE_MENU_ITEM_NAME = "Save";
    private final String SAVE_AS_MENU_ITEM_NAME = "Save as...";
    private final String FILE_NOT_LOADED = "Please load a file";
    private final JMenu menuFile;
    private final JMenuItem menuLoadFile;
    private final JMenuItem menuSaveFile;
    private final JMenuItem menuSaveAs;
    private final JFileChooser fileChooser;
    
    private RemindersFileReader fileReader;
    private boolean fileLoaded;

    public MenuBar(RemindersFileReader fileReader) {
        this();
        this.fileReader = fileReader;
    }    
    
    public MenuBar() {
        this.fileLoaded = false;
        this.fileChooser = new JFileChooser();
        this.menuFile = new JMenu(FILE_MENU_NAME);
        this.menuLoadFile = new JMenuItem(LOAD_FILE_MENU_ITEM_NAME);
        this.menuLoadFile.addActionListener(this);
        this.menuSaveFile = new JMenuItem(SAVE_FILE_MENU_ITEM_NAME);
        this.menuSaveAs = new JMenuItem(SAVE_AS_MENU_ITEM_NAME);
        this.menuSaveAs.addActionListener(this);
        
        this.menuFile.add(this.menuLoadFile);
        this.menuFile.add(this.menuSaveFile);
        this.menuFile.add(this.menuSaveAs);
        add(this.menuFile);
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
        if(source == this.menuLoadFile) {
            this.fileLoaded = true;
            if(this.fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.fileReader.loadFile(fileChooser.getSelectedFile());
            }
        }
        else if(source == this.menuSaveFile) {
            if(!this.fileLoaded) {
                JOptionPane.showMessageDialog(this, FILE_NOT_LOADED);
            }
            else {
                this.fileReader.save();
            }
        }
        else if(source == this.menuSaveAs) {
            this.fileLoaded = true;
            if(this.fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.fileReader.loadAndSaveFile(fileChooser.getSelectedFile());
            }
        }
    }
}
