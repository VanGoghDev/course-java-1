package firsov.Kirill;

public class Person {

    private String fio;
    private String position;
    private String email;
    private String telephoneNumber;
    private String salary;
    int age;

    Person(String fio, String position, String email, String telephoneNumber, String salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void printInfo (){
        System.out.println("FIO: " + this.fio);
        System.out.println("Position: " + this.position);
        System.out.println("Email adress: " + this.email);
        System.out.println("Telephone number: " + this.telephoneNumber);
        System.out.println("Salary: " + this.salary);
        System.out.println("Age: " + this.age);
    }
}
