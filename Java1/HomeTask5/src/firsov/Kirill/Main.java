package firsov.Kirill;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Firsov Kirill Igorevich", "Java developer", "kifirigor@gmail.com", "+7(915)-001-33-20", "70000", 21);
        persArray[1] = new Person("Krasilshikov Mikhail Naumovich", "Head of 704 department", "kras@mail.ru", "+7(999)-999-99-99", "300000", 79);
        persArray[2] = new Person("Bulichev Andrey Alekseevich", "BOSS", "Andrew_Bul@gmail.com", "+7(777)-777-77-77", "35000", 25);
        persArray[3] = new Person("Petrov Egor Dmitrievich", "Head Economist", "RKN-PLS-DIE!!!@sos.ru", "+7(909)-920-07-07", "1000000", 20);
        persArray[4] = new Person("Some guy", "Some job", "Some email@gmail.com", "+7(915)-000-0-000", "0000", 41);

        for (Person aPersArray : persArray) {
            if (aPersArray.age > 40) {
                aPersArray.printInfo();4
                System.out.println();
            }
        }

    }
}
