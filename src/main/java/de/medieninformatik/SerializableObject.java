package de.medieninformatik;

import java.io.Serializable;

public class SerializableObject implements Serializable, MyInterface {
    private int num;

    public SerializableObject(int num){
        this.num = num;
    }

    @Override
    public void printSelf() {
        System.out.println("I am serializable Nr."+num);
    }
}
