package maman14b;

import java.io.File;
import java.util.HashMap;

public class RemindersFileReader {
    private HashMap<MyDate, String> reminders;
    private File file;
    
    public RemindersFileReader(File file) {
        this();
        this.file = file;
    }

    public RemindersFileReader() {
        this.reminders = new HashMap <>();
    }

    public File getFile() {
        return file;
    }

    public void loadFile(File file) {
        this.file = file;
        this.reminders = (HashMap<MyDate, String>) FileOperation.readObjectFromFile(file);
    }
    
    public void loadAndSaveFile(File file) {
        this.file = file;
        save();
    }
    
    public void save() {
        FileOperation.writeObjectToFile(file, this.reminders);
    }
    
    public String getReminder(MyDate date) {
        return this.reminders.get(date);
    }
    
    public void addReminder(MyDate date, String text) {       
        reminders.put(date, text);
    }
}
