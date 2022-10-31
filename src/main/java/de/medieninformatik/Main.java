package de.medieninformatik;

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
 * Die Klasse laesst eine nicht serialisierbare Liste und eine serialisierbare Liste serialisieren und deserialisieren. <br>
 * Die serialisierbare Liste entaelt nicht serialisierbare Objekte.<br>
 * Diese werden bei der Serialisierung uebersprungen.<br>
 * Die Objekte, die das List-Interface implementieren, implementieren fuer den Testfall das MyInterface.
 */
public class Main {
    private static MySerializer m; //Eigene Klasse fuer Serialisierung / Deserialisierung

    /**
     * Erstellen der Listen und starten des Serialisierens und Deserialisiertes.
     *
     * @param args User-Argumente.
     */
    public static void main(String[] args) {
        m = new MySerializer();
        NonSerializableList<String> s = new NonSerializableList<>();    //Implementiert kein Serializable
        LinkedList<MyInterface> s2 = new LinkedList<>();    //Implementiert Serializable
        s2.add(new SerializableObject(1));  //Serialisierbar
        s2.add(new SerializableObject(2));  //Serialisierbar
        s2.add(new NonSerializableObject(1));  //Nicht Serialisierbar
        s2.add(new NonSerializableObject(2));  //Nicht Serialisierbar

        serAndDeser(s); //Serialisieren und De serialisieren ohne Serializable
        serAndDeser(s2); //Serialisieren und De serialisieren mit Serializable
    }

    /**
     * Ruft die Serialisierung und Deserialisierung des MySerializer Objektes mit dem uebergebenen Objekt auf.
     *
     * @param t   Objekt, das das List-Interface implementiert und (de)serialisiert werden soll.
     * @param <T> Uebergebenes Objekt, das das List-Interface implementiert.
     * @param <R> Objekttyp der Liste (MyInterface Objekte als Testfall gewaehlt).
     */
    private static <T extends List<R>, R> void serAndDeser(T t) {
        //Serialisieren nach List.ser
        try {
            m.serialize(t);
            System.err.println("Successfully serialized " + t);
        } catch (Exception e) {
            System.err.println("Error during Serialization of " + t.toString());
        }

        //De serialisieren aus List.ser und Ausgabe als MyInterface Objekte (<R>)
        try {
            //De serialisieren
            T deserList = (T) m.deserialize(t);

            //Umwandlung in MyInterface Objekte zur Ausgabe (nur als Ueberpruefung auf Korrektes Verhalten)
            if (!deserList.equals(null))
                deserList.forEach(obj -> {
                    MyInterface my = (MyInterface) obj;
                    my.printSelf();
                });
            System.err.println("Successfully deserialized " + deserList);
        } catch (Exception e) {
            System.err.println("Error during Deserialization of " + t.toString());
        }
    }
}
