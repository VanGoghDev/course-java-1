package firsov.Kirill;

public class Cat extends Animal{

    public Cat(String name) {
        super(name);

        this.maxHeight = 2;
        this.maxRun = 200;
        this.maxSwim = 0;
        setSpread();
    }
}
