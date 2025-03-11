package Basics;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {

    public static void main(String[] args){
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
        list.add("sindhu");
        list.add("karthik");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);

            if(name.equals("karthik")){
                list.add("banda");
            }
        }

        System.out.println(list);
    }
}
