package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {
    public static void capitalizeAndPrint(String word){
        if (word == null || word.isEmpty()) {
            System.out.println(word);
            return;
        }
        String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1);
        System.out.println(capitalized);
    }

    public static void main(String[] args){
        List<String> words = new ArrayList<>(Arrays.asList("hello", "java", "learners"));

        words.forEach(MethodReference::capitalizeAndPrint);
    }


    static class SortNumbers{
        public static void main(String[] args){
            List<Integer> numbers = Arrays.asList(1,3,5,7,8,4,2);
            List<Integer> sortedList = numbers.stream()
                    .sorted(Integer::compareTo).toList();
            System.out.println(sortedList);
        }
    }
}
