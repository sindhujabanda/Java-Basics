package Basics;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args){
        List<String> names = Arrays.asList("Sindhu", "Karthik", "Jack", "Ken");
        Map<String, Integer> map = names.stream().collect(Collectors.toMap(n->n, n->n.length()));
        System.out.println(map);
    }
}
