package de.medieninformatik;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * @author Sebastian Siebert m30116
 * @author Luca Spirka m29987
 * @version 1.0
 * <p>
 * Programmieren 3 - Aufgabe 05.
 * <p>
 * 2022-10-24
 * <p>
 * Die Klasse implementiert eine eigene Serialisierung und De Serialisierung fuer Objekte die dem List Interface genuegen.<br>
 * Nicht Serialisierbare Listen koennen dementsprechend nicht serialisiert werden und werfen einen Error. <br>
 * Nicht Serialisierbare Objekte innerhalb Serialisierbarer Listen werden nicht serialisiert.
 * */

public class MySerializer<T extends List<R>, R> {
    public void serialize(T t) throws NotSerializableException {
        if(!(t instanceof Serializable)) throw new NotSerializableException("Not Serializable!");
        List copy = new LinkedList<R>();
        for (R r :t) {
          if(r instanceof Serializable) copy.add(r);
        }
        /*for (int i = 0; i < t.size(); i++) {
            R obj = t.get(i);
            if (!(obj instanceof Serializable)) t.remove(i--);
        }*/
        String path = "List.ser";
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))){
            os.writeObject(copy);
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
