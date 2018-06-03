package firsov.Kirill;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    // количество элементов в массиве животных
    private static int i = 1;
    private static Animal animals[] = new Animal[i];

    public static void main(String[] args) {
        // write your code here
        Cat umka = new Cat("Umka");
        umka.printResult(umka.run(1000));

        Dog bull = new Dog("Puppy");
        bull.printResult(bull.swim(8));
        game();
    }

    private static void game(){
        boolean key = true;
        while(key){
            key = checkCondition();
            addAnimal();
        }
    }

    private static boolean checkCondition(){
        System.out.println("Do u wish to play a game? Yes-1/No-2");
        int answer = sc.nextInt();
        return answer == 1;
    }

    private static void addAnimal(){
        System.out.println("Do you want to add an animal? Yes-1/No-2");
        int answer = sc.nextInt();
        if (answer == 1){

            animals = resize(animals, i);
            i += 1;

            System.out.println("Cat - 1; Dog - 2");
            answer = sc.nextInt();
            if (answer == 1){
                System.out.println("What is the name of your animal?");
                String name = sc.toString();
                Cat newAnimal = new Cat(name);
                animals[i-2] = newAnimal;
            } else {
                System.out.println("What is the name of your animal?");
                String name = sc.toString();
                Dog newAnimal = new Dog(name);
                animals[i-2] = newAnimal;
            }
            System.out.println("You have added" + animals[i-2].name);
        }
    }

    private static Animal[] resize(Animal[] source, int newLength){
        Animal[] a = new Animal[newLength];
        for (int i = 0; i < newLength ; i++) {
            a[i] = source[i];
        }
        return a;
    }
}
