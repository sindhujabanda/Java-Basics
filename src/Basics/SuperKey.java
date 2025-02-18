package Basics;

public class SuperKey {
    String color = "White";
    SuperKey(){
        System.out.println("This is Super Class Constructor");
    }
}
class Baby extends SuperKey{
        String color = "Black";
        Baby(){
            super();
        }
        public void features(){
            System.out.println(color);
            System.out.println(super.color);
        }
}


class Test{
        public static void main(String[] args){
            Baby baby = new Baby();
            baby.features();
        }
}

