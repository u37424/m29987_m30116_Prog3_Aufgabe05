package de.medieninformatik;

import java.io.Serializable;

/**
 * @author Sebastian Siebert m30116
 * @author Luca Spirka m29987
 * @version 1.0
 * <p>
 * Programmieren 3 - Aufgabe 05.
 * <p>
 * 2022-10-24
 * <p>
 * Die Klasse implementiert ein Serialisierbares Objekt mit der MyInterface Schnittstelle zur Kontrolle.
 */
public class SerializableObject implements Serializable, MyInterface {
    //Testnummer
    private int num;

    public SerializableObject(int num) {
        this.num = num;
    }

    /**
     * Ausgabe zur Kontrolle des Objektes.
     */
    @Override
    public void printSelf() {
        System.out.println("I am serializable Nr." + num);
    }
}
