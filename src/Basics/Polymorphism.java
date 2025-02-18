package Basics;


//Method Overloading
public class Polymorphism {
    public int add(int a, int b){
        return a+b;
    }

    public int add(int a, int b, int c){
        return a+b+c;
    }
}

class Addition{
    public static void main(String[] args){
        Polymorphism polymorphism = new Polymorphism();
        System.out.println("two " + polymorphism.add(1,2));
        System.out.println("Three " + polymorphism.add(1,2,3));
    }
}

//Method Overriding
//Upcasting-Reference variable of the parent class refers to the object of Sub class
class Bike{
    void run(){
        System.out.println("Bike is Running");
    }
}

class RX100 extends Bike{
    void run(){
        System.out.println("Bike is Running with 60KMPH");
    }

    public static void main(String[] args){
        Bike bike = new RX100();//Upcasting
        bike.run();
    }
}
