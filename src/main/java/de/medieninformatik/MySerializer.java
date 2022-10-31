package de.medieninformatik;

import java.io.*;
import java.util.List;

public class MySerializer<T extends List<R>, R> {
    public void serialize(T t) throws NotSerializableException {
        if(!(t instanceof Serializable)) throw new NotSerializableException("Not Serializable!");
        for (int i = 0; i < t.size(); i++) {
            R obj = t.get(i);
            if (!(obj instanceof Serializable)) t.remove(i--);
        }
        String path = "List.ser";
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))){
            os.writeObject(t);
        } catch (Exception e){
            System.err.println("Error during serialization of Object!");
        }
    }

    public T deserialize(T t) throws NotSerializableException {
        if(!(t instanceof Serializable))  throw new NotSerializableException("Not Deserializable!");
        String path = "List.ser";
        try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(path))){
            return (T) os.readObject();
        } catch (Exception e){
            System.err.println("Error during serialization of Object!");
        }
        System.err.println("No Object Read.");
        return null;
    }
}
