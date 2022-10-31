package de.medieninformatik;

import java.util.LinkedList;
import java.util.List;

public class Main {
    private  static MySerializer m;

    public static void main(String[] args) {
        m = new MySerializer();
        NonSerializableList<String> s = new NonSerializableList<>();
        LinkedList<MyInterface> s2 = new LinkedList<>();
        s2.add(new SerializableObject(1));
        s2.add(new SerializableObject(2));
        s2.add(new NonSerializableObject(1));
        s2.add(new NonSerializableObject(2));

        serAndDeser(s);
        serAndDeser(s2);
    }

    private static<T extends List<R>, R> void serAndDeser(T s) {
        try {
            m.serialize(s);
        } catch (Exception e){
            System.err.println("Error during Serialization.");
        }

        try {
            T t = (T) m.deserialize(s);
            t.forEach(obj -> {
                MyInterface my = (MyInterface) obj;
                my.printSelf();
            });
        } catch (Exception e){
            System.err.println("Error during Deserialization.");
        }
    }
}
