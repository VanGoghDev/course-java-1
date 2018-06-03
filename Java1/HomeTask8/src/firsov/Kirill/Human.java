package firsov.Kirill;

public class Human {

    public float weight;  // kg
    public int age;
    public float height;  // meters
    public char sex;
    public String name;
    public float bmi; // Body Mass Index result in i.u.
    public double bmr; // basal metabolic rate, BMR (рекомендуемая суточная калорийность)

    public Human(String humanName, char humanSex, int humanAge, float humanWeight, float humanHeight){

        name = humanName;
        sex = humanSex;
        age = humanAge;
        weight = humanWeight;
        height = humanHeight;
        bmi = weight / (height * height);

    }
}
