package firsov.Kirill;

public class Main {

    byte b = 0;
    short s = 0;
    int i = 0;
    long l = 0L;
    float f = 0.0f;
    double d = 0.0;
    char c = 'c';
    boolean bool = true;

    public static void main(String[] args) {
        System.out.println(calculate(2,2,2,2));
        System.out.println(task10and20(5, 6));
        isPositiveOrNegative(20);
        System.out.println(isNegative(-1));
        greetings("Александр");
        leapYear(20);
        String s = "value = " + 2 + 2;
        System.out.println(s);

    }

    public static void main(){

    }

    private static int calculate(int a, int b, int c, int d){
        return a * (b + (c / d));
    }

    private  static  boolean task10and20(int x1, int x2){
        return (x1 + x2) >= 10 && (x1 + x2) <= 20;
    }

    private  static void isPositiveOrNegative(int x){
        if(x > 0){
            System.out.println("Positive");
        }
        else{
            System.out.println("Negative");
        }
    }

    private static boolean isNegative(int x){
        return !(x > 0);
    }

    private static  void greetings(String name){
        System.out.println("Привет, " + name);
    }

    private static void leapYear(int year){
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)){
            System.out.println("Leap Year!");
        }
        else{
            System.out.println("Not a Leap Year!");
        }
    }
}
