package Basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomOrdering {

    int age;
    String name;

    public CustomOrdering(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomOrdering{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args){
        List<CustomOrdering> list = new ArrayList<>();
        list.add(new CustomOrdering(22, "sindhu"));
        list.add(new CustomOrdering(23,"banda"));
        list.add(new CustomOrdering(87, "kaali"));

        Comparator<CustomOrdering> nameComparator = new Comparator<CustomOrdering>() {
            @Override
            public int compare(CustomOrdering o1, CustomOrdering o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        Collections.sort(list, nameComparator);

        for(CustomOrdering co : list){
            System.out.println(co);
        }
    }
}
