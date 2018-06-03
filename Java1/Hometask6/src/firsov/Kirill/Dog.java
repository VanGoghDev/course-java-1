package firsov.Kirill;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        this.maxHeight = 1;
        this.maxRun = 500;
        this.maxSwim = 10;
        setSpread();
    }
}
