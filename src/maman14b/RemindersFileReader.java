package maman14b;

import java.io.File;
import java.util.HashMap;

public class RemindersFileReader {
    private HashMap<MyDate, String> reminders;
    private File file;
    
    /**
     * Constructor
     * @param file File object 
     */
    public RemindersFileReader(File file) {
        this();
        this.file = file;
    }

    /**
     * Empty constructor
     */
    public RemindersFileReader() {
        this.reminders = new HashMap <>();
    }

    /**
     * Get the file
     * @return File object
     */
    public File getFile() {
        return file;
    }

    /**
     * Load file 
     * @param file File object
     */
    public void loadFile(File file) {
        this.file = file;
        this.reminders = (HashMap<MyDate, String>) FileOperation.readObjectFromFile(file);
    }
    
    /**
     * Load a new file, and the save the reminders to it
     * @param file File object
     */
    public void loadAndSaveFile(File file) {
        this.file = file;
        save();
    }
    
    /**
     * Save the reminders to the loaded file
     */
    public void save() {
        FileOperation.writeObjectToFile(file, this.reminders);
    }
    
    /**
     * Get the reminders attached to the given date
     * @param date MyDate object
     * @return String text
     */
    public String getReminder(MyDate date) {
        return this.reminders.get(date);
    }
    
    /**
     * Add a reminder
     * @param date MyDate object
     * @param text String text
     */
    public void addReminder(MyDate date, String text) {       
        reminders.put(date, text);
    }
}
