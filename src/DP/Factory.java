package DP;

interface Shape{
    void showDetails();
}
public class Factory implements Shape{

    @Override
    public void showDetails() {
        System.out.println("DEV");
    }
}

class Manager implements Shape{

    @Override
    public void showDetails() {
        System.out.println("MAN");
    }
}

class EmpFactory{
    public static Shape getEmp(String type){
        if(type.equalsIgnoreCase("DEV1")){
            return new Factory();
        } else if(type.equalsIgnoreCase("MAN1")){
            return new Manager();
        }
        return null;
    }
}

class FactoryExample{
    public static void main(String[] args){
        Shape shape1 = EmpFactory.getEmp("MAN1");
        shape1.showDetails();
    }
}
