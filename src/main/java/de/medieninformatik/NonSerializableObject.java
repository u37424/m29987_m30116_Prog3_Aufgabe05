package de.medieninformatik;

public class NonSerializableObject implements MyInterface{
    private int num;

    public NonSerializableObject(int num){
        this.num = num;
    }

    @Override
    public void printSelf() {
        System.out.println("I am not serializable Nr."+num);
    }
}
