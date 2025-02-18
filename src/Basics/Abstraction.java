package Basics;

//Abstract class
public abstract class Abstraction {
    abstract int getInterest();
}
class SBI extends Abstraction {
    int getInterest(){
        return 5;
    }
}

class HDFC extends Abstraction{
    int getInterest(){
        return 7;
    }

    public static void main(String[] args){
       Abstraction a;
       a = new SBI();
       System.out.println(a.getInterest());
       a = new HDFC();
       System.out.println(a.getInterest());
    }
}

