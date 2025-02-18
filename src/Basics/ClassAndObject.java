package Basics;

public class ClassAndObject {
    String name;
    int age;

   public ClassAndObject(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
       return name + " - " + age;
    }

    public static void main(String[] args){
       ClassAndObject c1 = new ClassAndObject("Sindhu", 29);
       System.out.println(c1);
    }
}
