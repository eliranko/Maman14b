package maman14b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public void setFile(File file) {
        this.file = file;
        updateReminders();
    }

    public String getReminder(MyDate date) {
        return this.reminders.get(date);
    }
    
    public boolean addReminder(MyDate date, String text) {
        // Don't save any information until a file is loaded
        if(file == null) return false;
        
        reminders.put(date, text);
        return saveToFile();
    }
    
    private void updateReminders() {
        this.reminders = readFromFile();
    }
    
    private HashMap<MyDate, String> readFromFile() {
        HashMap<MyDate, String> data;

        try {
            FileInputStream fis = new FileInputStream(this.file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            data = (HashMap<MyDate, String>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch(FileNotFoundException e) {
            return new HashMap<>();
        }
        catch(IOException e) {
           return new HashMap<>();
        }
        catch(ClassNotFoundException e) {
           return new HashMap<>(); 
        }

        return data;
    }
    
    private boolean saveToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(this.file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(this.reminders);
            oos.close();
            fos.close();
        }
        catch(FileNotFoundException e) {
            System.err.println(e.toString());
            return false;
        }
        catch(IOException e) {
            System.err.println(e.toString());
            return false;
        }
        
        return true;
    }
}
