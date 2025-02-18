package Basics;
//Single
public class Inheritance {
    int salary = 10000;
}

class Emp extends Inheritance {
    int bonus = 5000;

    public static void main(String[] args) {
            Emp emp = new Emp();
            System.out.println(emp.salary);
            System.out.println(emp.bonus);
    }

}

//Multi-level

class Animal{
    void eat(){
        System.out.println("Eating...");
    }
}

class Dog extends Animal{
    void bark(){
        System.out.println("Barking...");
    }
}

class BabyDog extends Dog{
    void roam(){
        System.out.println("Roaming...");
    }

    public static void main(String[] args){
        BabyDog babyDog = new BabyDog();
        babyDog.eat();
        babyDog.bark();
        babyDog.roam();
    }
}

//Hierarchical

class Car{
    String type = "Car";
}

class BMW extends Car{
    String carName = "BMW";
}

class Audi extends Car{
    String carName = "Audi";

    public static void main(String[] args){
        Audi audi = new Audi();
        System.out.println(audi.type);
        System.out.println(audi.carName);
    }
}