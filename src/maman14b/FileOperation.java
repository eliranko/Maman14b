package maman14b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileOperation {
    
    /**
     * Read object to file
     * @param file File to read the object from
     * @return Object read from file
     */
    public static Object readObjectFromFile(File file) {
        Object data;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            data = ois.readObject();
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
    
    /**
     * Write object to file
     * @param file File to write the object to
     * @param object Object to write
     */
    public static void writeObjectToFile(File file, Object object) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(object);
            oos.close();
            fos.close();
        }
        catch(FileNotFoundException e) {
            System.err.println(e.toString());
        }
        catch(IOException e) {
            System.err.println(e.toString());
        }
    }
}
