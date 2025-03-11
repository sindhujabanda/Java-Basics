package Basics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapExample {

    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();
        map.put("sindhu", "s");
        map.put("karthik", "k");
        map.put("arjun", "a");

        Map<String, String> sortedMap = new TreeMap<>(map);

        for (Map.Entry<String, String> entry : sortedMap.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

}
