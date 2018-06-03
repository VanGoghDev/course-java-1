package firsov.Kirill;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(150);

        Cat cats[] = new Cat[5];
        cats[0] = new Cat("Barsik", 5);
        cats[1] = new Cat("Umka", 4);
        cats[2] = new Cat("Pushistik", 3);
        cats[3] = new Cat("Begemot", 8);
        cats[4] = new Cat("Vincent", 6);
        for (Cat cat1 : cats) {
            cat1.eat(plate);
        }
    }
}
