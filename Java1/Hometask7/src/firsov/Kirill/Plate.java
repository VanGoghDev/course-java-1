package firsov.Kirill;

public class Plate {

    int food;

    Plate(int food) {
        this.food = food;
    }

    void info() {
        if (food <= 0) {
            System.out.println("plate is empty");
        } else {
            System.out.println("plate: " + food);
        }
    }

    void decreaseFood(int count) {
        if(food < count){
            System.out.println("Not Enough food in the plate");
        }else {
            food -= count;
            info();
        }
    }

    void increaseFood(int count) {
        food += count;
    }
}
