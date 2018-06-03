package firsov.Kirill;

public class Cat {

    private String name;
    private int appetite;
    private int satiety = 0;
    private static final int CAT_IS_FULL = 15;
    private static boolean SATIETY = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (CAT_IS_FULL > satiety){
            if (appetite > p.food){
                System.out.println("I need more food");
            }else {
                satiety += appetite;
                p.decreaseFood(appetite);
                SATIETY = false;
            }
        } else{
            System.out.println("It`s enough for this pussy");
            SATIETY = true;
        }
    }
}

