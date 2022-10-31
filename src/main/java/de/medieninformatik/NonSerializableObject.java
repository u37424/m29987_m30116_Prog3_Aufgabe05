package de.medieninformatik;
/**
 * @author Sebastian Siebert m30116
 * @author Luca Spirka m29987
 * @version 1.0
 * <p>
 * Programmieren 3 - Aufgabe 05.
 * <p>
 * 2022-10-24
 * <p>
 * Die Klasse implementiert ein Nicht Serialisierbares Objekt mit der MyInterface Schnittstelle zur Kontrolle.*/

public class NonSerializableObject implements MyInterface{
    //Testnummer
    private int num;

    public NonSerializableObject(int num){
        this.num = num;
    }

    /**
     * Ausgabe zur Kontrolle des Objektes.
     */
    @Override
    public void printSelf() {
        System.out.println("I am not serializable Nr."+num);
    }
}
