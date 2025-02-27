package Basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NaturalOrdering implements Comparable<NaturalOrdering>{

    int age;
    String name;

    public NaturalOrdering(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "NaturalOrdering{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(NaturalOrdering no) {
        return Integer.compare(this.age, no.age);
    }

    public static void main(String[] args){
        List<NaturalOrdering> list = new ArrayList<>();
        list.add(new NaturalOrdering(76,"ban"));
        list.add(new NaturalOrdering(45,"dan"));
        list.add(new NaturalOrdering(88,"kan"));

        Collections.sort(list);

        for(NaturalOrdering no: list){
            System.out.println(no);
        }
    }
}
