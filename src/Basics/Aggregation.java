package Basics;

public class Aggregation {
    String name;
    int age;
    Address address;

    public Aggregation(String name, int age, Address address){
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
class Address {
    String city, state, country;
    public Address(String city, String state, String country){
        this.city = city;
        this.state = state;
        this.country = country;
    }
}

class Employees{
    public static void main(String[] args) {
        Address address1 = new Address("Knr", "TN", "India");
        Address address2 = new Address("Hyd", "TN", "India");

        Aggregation  aggregation = new Aggregation("Sindhu", 21, address1);
        Aggregation aggregation1 = new Aggregation("Karthik", 22, address2);

        System.out.println(aggregation.name);
        System.out.println(aggregation1.age);
    }
}

