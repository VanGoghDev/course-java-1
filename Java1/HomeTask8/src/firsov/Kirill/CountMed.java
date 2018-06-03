package firsov.Kirill;

import java.util.Scanner;

public class CountMed {

    private Scanner sc = new Scanner(System.in);

    public float weight;  // kg
    public int age;
    public float height;  // meters
    public char sex;
    public String name;
    public float bmi; // Body Mass Index result in i.u.
    public double bmr; // basal metabolic rate, BMR (рекомендуемая суточная калорийность)

    public CountMed(Human human) {
        name = human.name;
        sex = human.sex;
        age = human.age;
        weight = human.weight;
        height = human.height / 100;
        bmi = weight / (height * height);
    }

    private String weightParam(int a, int b){
        String foo;
        if (bmi >= a && bmi <= b){
            foo = "Acceptable weight";
        }else if (bmi < 19){
            foo = "Lack of weight";
        }else{
            foo = "Obesity";
        }
        return foo;
    }

    public void countBMI(){
        String weightParam;
        if (age >= 14 && age <= 24){
            weightParam = weightParam(19, 24);
        }else if (age >= 25 && age <= 34){
            weightParam = weightParam(20, 25);
        }else if (age >= 35 && age <= 44){
            weightParam = weightParam(21, 26);
        }else if(age >= 45 && age <= 54){
            weightParam = weightParam(22, 27);
        }else if (age >= 55 && age <= 65){
            weightParam = weightParam(23, 28);
        }else{
            weightParam = weightParam(24, 29);
        }
        System.out.println("You have " + weightParam);
    }

    public void countBMR(int flagActivity, int flagGoal){
        if (sex == 'M'){
            bmr = 88.36 + (13.4 * weight) + (4.8 * height * 100) - (5.7 * age);
        }else{
            bmr = 447.6 + (9.2 * weight) + (3.1 * height * 100) - (4.3 * age);
        }

        double activityLevel;

        int answer =flagActivity;
        switch(answer){
            case 1:
                activityLevel = 1.2;
                break;
            case 2:
                activityLevel = 1.375;
                break;
            case 3:
                activityLevel = 1.55;
                break;
            case 4:
                activityLevel = 1.8;
                break;
            default:
                activityLevel = 1.2;
        }

        bmr *= activityLevel;

        answer = flagGoal;
        switch (answer){
            case 1:
                bmr -= bmr * 0.2;
                break;
            case 2:
                bmr -= bmr * 0.1;
                break;
            case 3:
                break;
            case 4:
                bmr += bmr * 0.1;
                break;
            case 5:
                bmr += bmr * 0.2;
                break;
            default:
                break;
        }

        double proteins;
        double fats;
        double carbs;
        if (sex == 'M'){
            proteins = weight * 1.5;
            fats = weight * 0.8;
        }else{
            proteins = weight * 1.2;
            fats = weight * 0.9;
        }
        carbs = (bmr - proteins * 4 - fats * 9) / 4;


        System.out.println("You should take in " + bmr + " calories");  // добавить округление
        System.out.println("Your calories should contain:");
        System.out.println("1. " + proteins + " grams of proteins; ");
        System.out.println("2. " + fats + " grams of fats;");
        System.out.println("3. " + carbs + " grams of carbs");
    }

}
