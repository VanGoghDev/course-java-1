package firsov.Kirill;

import java.util.Random;

public abstract class Animal {

    String name;
    int maxHeight;
    int maxSwim;
    int maxRun;
    int heightDistanceMax;
    int runDistanceMax;
    int swimDistanceMax;

    Animal(String name) {
        this.name = name;
        this.maxHeight = 0;
        this.maxSwim = 0;
        this.maxRun = 0;
        setSpread();
    }

    // Процедура отвечающая за случайный разброс
    void setSpread(){
        Random rnd = new Random(System.currentTimeMillis());

        int maxValue = rnd.nextInt(this.maxHeight + 1);
        heightDistanceMax = maxValue;

        maxValue = rnd.nextInt(this.maxSwim + 1);
        swimDistanceMax = maxValue;

        maxValue = rnd.nextInt(this.maxRun + 1);
        runDistanceMax = maxValue;

    }

    boolean jumpInHeight(int barrier){
        return this.heightDistanceMax > barrier;
    }

    boolean swim(int barrier){
        return this.swimDistanceMax > barrier;
    }

    boolean run(int barrier){
        return this.runDistanceMax > barrier;
    }

    public void printResult(boolean result){
        System.out.println(this.name + " passed the barrier with the result:" + result);
    }
}
